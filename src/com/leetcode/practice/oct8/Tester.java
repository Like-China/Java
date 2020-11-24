/**  

* <p>Title: Tester.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2020 like_czw@gmail.com</p>  

* <p>Company: UESTC</p>  

* @author Ke Li 

* @date 2020Äê11ÔÂ17ÈÕ  

* @version 1.0  

*/  
package com.leetcode.practice.oct8;


public class Tester extends Thread{
	public static void main(String[] args){
		
		try {
			Thread t = new Tester();
			t.run();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public void sayHello()
	{
		System.out.println("Hello");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			sayHello();
		}
	}
	
	
	
	
	
}

