package com.test.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * 请求工具类
 */
public class UrlUtil {
	
	private static Logger logger = LoggerFactory.getLogger(UrlUtil.class);
	
	public static String sendPost(String url, String param) throws Exception {
		return sendPost(url, param, null);
	}
	
	/**
	 * 向指定URL发送post方法的请求
	 *
	 * @param url
	 * @param param
	 * @param charsetName
	 * @return
	 * @throws Exception
	 */
	public static String sendPost(String url, String param, String charsetName) throws Exception {
		logger.info("发送请求URL={},参数:{}", url, param);
		if (StringUtils.isBlankContNull(charsetName)) {
			charsetName = "UTF-8";
		}
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			// 用这个类来创建连接
			URL realUrl = new URL(url);
			// 打开和url之间的连接
			URLConnection conn = realUrl.openConnection();
			// 发送post请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 超时15秒
			conn.setReadTimeout(15 * 1000);
			conn.setConnectTimeout(15 * 1000);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charsetName));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			logger.info("请求返回结果:{}", result);
		} finally {
			// 使用finally来关闭输入,输出流
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		}
		return result;
	}
	
}
