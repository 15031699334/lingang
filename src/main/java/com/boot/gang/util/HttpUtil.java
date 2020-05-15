package com.boot.gang.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpUtil {
	/**
	 * 向请求方打印信息
	 * @param response
	 * @param msg
	 */
	public static void responseOut(HttpServletResponse response,String msg){
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = null;
         try {
        	 out = response.getWriter();
             out.println(msg);                      
         }catch (Exception e) {
        	 e.printStackTrace();
         }finally {   
        	out.flush();
            out.close();
        }
	}
	
	/**
	 * 将字节流转换为字符串
	 * */ 
	public static String readStreamParameter(ServletInputStream in){
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader=null;
		try{
			//reader = new BufferedReader(new InputStreamReader(in,"ISO-8859-1"));
			reader = new BufferedReader(new InputStreamReader(in,"utf-8"));
			String line=null;
			while((line = reader.readLine())!=null){
				buffer.append(line);
            }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(null!=reader){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return buffer.toString();
	}
	
	/**
	 * 执行HTTPClient请求   Url传参
	 * @param urlStr   请求地址
	 * @param charset 是否设置字符集  0为不设置 大于0为设置   全英文不需要设置
	 * @return	请求结果
	 */
	public static String excuteGetClient(String urlStr, String params, String charset) {
		String resultStr = null;
		HttpClient httpclient = new HttpClient();
		urlStr = urlStr + params;
//		logger.info(urlStr);
		HttpMethod method = new GetMethod(urlStr);
		if (null != charset) {
			method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + charset);
		} else {
			method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
		}
		try
		{
			httpclient.executeMethod(method);
			resultStr = method.getResponseBodyAsString();
		}
		catch (Exception e)
		{
			resultStr = null;
			e.printStackTrace();
		}
		return resultStr;
	}
	
	/**
	 * Post数据到对应的地址
	 * @param urlStr
	 * @param postStr
	 * @param charsetType 0不设置  1"Content-type", "text/xml; charset=utf-8"   2"Content-type", "application/json; charset=utf-8"
	 * @return
	 */
	public static String excutePostClient(String urlStr,String postStr,int charsetType){
		String resultStr = null;
	/*	try {
			urlStr = URLEncoder.encode(urlStr, "UTF-8");
		} catch (Exception e1) {
			e1.printStackTrace();
		}*/
		PostMethod method = new PostMethod(urlStr);
		if(charsetType==1){
			method.setRequestHeader("Content-type", "text/xml; charset=utf-8"); //设置头
		}else if(charsetType == 2){
			method.setRequestHeader("Content-type", "application/json; encoding=utf-8"); //设置头
		}
		method.setRequestBody(postStr);				//设置内容
        HttpClient httpclient = new HttpClient();      		// 创建 HttpClient的实例
        try {
			int result = httpclient.executeMethod(method);//执行请求
			resultStr = method.getResponseBodyAsString();	// 返回内容
		} catch (Exception e) {
			e.printStackTrace();
		}  		
        method.releaseConnection();                                 // 释放连接	
		return resultStr;
	}
	
	public static String connectHttpsByPost(String urlStr,File file) throws Exception{
		String result =null;  

		URL url = new URL(urlStr);
		
		URLConnection con = url.openConnection();
		
		con.setDoInput(true);  
		  
		con.setDoOutput(true);  
		  
		con.setUseCaches(false); // post方式不能使用缓存  
		  
		// 设置请求头信息  
		  
		con.setRequestProperty("Connection", "Keep-Alive");  
		  
		con.setRequestProperty("Charset", "UTF-8");  
		// 设置边界  
		  
		String BOUNDARY = "----------" + System.currentTimeMillis();  
		  
		con.setRequestProperty("Content-Type",  
		        "multipart/form-data; boundary="  
		  
		        + BOUNDARY);  
		  
		// 请求正文信息  
		  
		// 第一部分：  
		  
		StringBuilder sb = new StringBuilder();  
		  
		sb.append("--"); // 必须多两道线  
		  
		sb.append(BOUNDARY);  
		  
		sb.append("\r\n");  
		  
		sb.append("Content-Disposition: form-data;name=\"media\";filelength=\""+file.length()+"\";filename=\""  
		  
		        + file.getName() + "\"\r\n");  
		  
		sb.append("Content-Type:application/octet-stream\r\n\r\n");  
		  
		byte[] head = sb.toString().getBytes("utf-8");  
		  
		// 获得输出流  
		  
		OutputStream out = new DataOutputStream(con.getOutputStream());  
		  
		// 输出表头  
		  
		out.write(head);  
		  
		// 文件正文部分  
		  
		// 把文件已流文件的方式 推入到url中  
		  
		DataInputStream in = new DataInputStream(new FileInputStream(file));  
		  
		int bytes = 0;  
		  
		byte[] bufferOut = new byte[1024];  
		  
		while ((bytes = in.read(bufferOut)) != -1) {  
		  
		    out.write(bufferOut, 0, bytes);  
		  
		}  
		  
		in.close();  
		  
		// 结尾部分  
		  
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线  
		  
		out.write(foot);  
		  
		out.flush();  
		  
		out.close();  
		  
		StringBuffer buffer = new StringBuffer();  
		  
		BufferedReader reader = null;  
		  
		try {  
		  
		    // 定义BufferedReader输入流来读取URL的响应  
		  
		    reader = new BufferedReader(new InputStreamReader(con.getInputStream()));  
		  
		    String line = null;  
		  
		    while ((line = reader.readLine()) != null) {  
		  
		        buffer.append(line);  
		  
		    }  
		  
		    if (result == null) {  
		  
		        result = buffer.toString();  
		  
		    }  
		  
		} catch (IOException e) {  
		  
		    System.out.println("发送POST请求出现异常！" + e);  
		  
		    e.printStackTrace();  
		  
		    throw new IOException("数据读取异常");  
		  
		} finally {  
		  
		    if (reader != null) {  
		  
		        reader.close();  
		  
		    }  
		  
		}  
		return result;  
	}
	
	
	public static String getIpAddrddd(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for"); 
        System.out.println("x-forwarded-for ip: " + ip);
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {  
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if( ip.indexOf(",")!=-1 ){
                ip = ip.split(",")[0];
            }
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("X-Real-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        } 
        return ip;  
    }
}
