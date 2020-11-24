/**  

* <p>Title: GreetingServer.java</p>  

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
import java.net.ServerSocket;
import java.net.Socket;

public class GreetingServer extends Thread{
	
	/**
	 * 
	 */
	ServerSocket serverSocket;
	public GreetingServer(int port) throws IOException{
		// TODO Auto-generated constructor stub
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				System.out.println("等待连接");
				Socket server = serverSocket.accept();
				System.out.println("连接已经建立");
				
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("我是服务器端");
				
				DataInputStream in = new DataInputStream(server.getInputStream());
				System.out.println("收到客户端数据；"+in.readUTF());
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("wrong");
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			Thread thread = new GreetingServer(6066);
			thread.run();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
