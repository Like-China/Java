package com.leetcode.practice.oct8;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode() {}
	public ListNode(int val) {this.val = val;}
	public ListNode(int val, ListNode next) { this.val = val; this.next = next;}
	
	
	// create a linked list based on a integer list
	public static ListNode createList(int[] nums)
	{
		ListNode head = null,tail = null;
		for(int i=0;i<nums.length;i++) {
			if(head == null)
			{
				head = tail = new ListNode(nums[i]);
			}else {
				tail.next = new ListNode(nums[i]);
				tail = tail.next;
			}
		}
		return head;
	}
	
	// show elements in a linked list
	public static void show(ListNode head)
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.printf("%d->",temp.val);
			temp = temp.next;
		}
	}
}
