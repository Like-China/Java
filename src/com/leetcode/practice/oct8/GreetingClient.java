/**  

* <p>Title: GreetingClient.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2020 like_czw@gmail.com</p>  

* <p>Company: UESTC</p>  

* @author Ke Li 

* @date 2020年11月23日  

* @version 1.0  

*/  
package com.leetcode.practice.oct8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GreetingClient {
	
	/**
	 * 
	 */
	Socket client;
	public GreetingClient(String serverName, int port) {
		// TODO Auto-generated constructor stub
		try {
			this.client = new Socket(serverName, port);
			System.out.println("连接成功");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("拒绝连接");
		}
	}
	
	/**
	 * 
	 */
	private String getDataFromServer() {
		// TODO Auto-generated method stub
		String data = null;
		try {
			DataInputStream inputStream = new DataInputStream(client.getInputStream());
			data = inputStream.readUTF();
			System.out.println("收到服务器端数据:"+data);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("无法获取数据");
		}
		return data;
	}
	
	/**
	 * 
	 */
	private void sendDataToServer(String data) {
		// TODO Auto-generated method stub
		try {
			DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
			outputStream.writeUTF(data);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("发送失败");
		}
	}
	
	public static void main(String[] args) throws IOException{
		GreetingClient cc = new GreetingClient("localhost", 6066);
		cc.getDataFromServer();
		cc.sendDataToServer("123");
		cc.client.close();
		
	}
	
	
}
