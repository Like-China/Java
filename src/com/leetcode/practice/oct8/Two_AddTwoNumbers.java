/**  

* <p>Title: Two_AddTwoNumbers.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2020 like_czw@gmail.com</p>  

* <p>Company: UESTC</p>  

* @author Ke Li 

* @date 2020年10月13日  

* @version 1.0  

*/  
package com.leetcode.practice.oct8;


//You are given two non-empty linked lists representing two non-negative integers. 
//The digits are stored in reverse order, and each of their nodes contains a single digit. 
//Add the two numbers and return the sum as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.


//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.

//Input: l1 = [0], l2 = [0]
//Output: [0]
		
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]

public class Two_AddTwoNumbers {
	/**
	 * Utilize % and / operations, and create a new linked list to store the result
	 * @param l1
	 * @param l2
	 * @return the result linked list head
	 */
	public static ListNode solution1(ListNode l1, ListNode l2)
	{
		int carry = 0;
		ListNode head = null, tail = null;
		while(l1 != null || l2 != null)
		{
			int val1 = (l1 == null)? 0:l1.val;
			int val2 = (l2 == null)? 0:l2.val;
			int sum = val1+val2+carry;
			if(head == null)
			{
				head = tail = new ListNode(sum%10);
			}else {
				tail.next = new ListNode(sum%10);
				tail = tail.next;
			}
			carry = sum/10;
			
			if(l1 != null) {l1 = l1.next;}
			if(l2 != null) {l2 = l2.next;}
			if(carry>0) {tail.next = new ListNode(carry);}
		}
		return head;
	}
	
	/**
	 * Utilize the raw linked list to store the result without space consuming
	 * Failed: Two new temp linked list are required.
	 * @param l1
	 * @param l2
	 * @return
	 */
	
	// test
	public static void main(String[] args) {
		// create a linked list
		ListNode l1 = ListNode.createList(new int[] {1,3,5,7,9});
		ListNode l2 = ListNode.createList(new int[] {2,4,6,8});
		ListNode.show(solution1(l1, l2));
	}
}
