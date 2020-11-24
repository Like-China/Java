/**  

* <p>Title: Max_Cross_Subarray.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2020 like_czw@gmail.com</p>  

* <p>Company: UESTC</p>  

* @author Ke Li 

* @date 2020年11月13日  

* @version 1.0  

*/  
package com.leetcode.practice.oct8;

import java.util.Arrays;

public class Max_Cross_Subarray {
	
	// 左边部分子数组的最大子数组
	public static int left_low_index;
	public static int left_high_index;
	public static int left_max_sum;
	// 右边部分子数组的最大子数组
	public static int right_low_index;
	public static int right_high_index;
	public static int right_max_sum;
	// 包含中间元素的最大子数组
	public static int center_low_index;
	public static int center_high_index;
	public static int center_max_sum;
	
	/**
	 * 查找包含数组最中间元素的最大子数组
	 * @param A
	 * @param left
	 * @param mid
	 * @param right
	 * @return
	 */
	public static int[] findMaxCrossSubarray(int[] A, int left, int mid, int right)
	{
		
		int sum = 0;
		int left_max = Integer.MIN_VALUE;
		int left_index = mid;
		for(int i=mid;i>=left;i--)
		{
			sum = sum + A[i];
			if(sum>left_max)
			{
				left_max = sum;
				left_index = i;
			}
		}
		
		sum = 0;
		int right_max = Integer.MIN_VALUE;;
		int right_index = mid;
		for(int i=mid+1;i<right;i++)
		{
			sum = sum + A[i];
			if(sum>right_max)
			{
				right_max = sum;
				right_index = i;
			}
		}
		
		return new int[]{left_index, right_index, left_max+right_max};
	}
	
	
	public static int[] findMaxSubArray(int[] A, int left,  int right)
	{
		if(left == right)
		{
			System.out.println("return: "+left+"="+right+"="+left);
			return new int[] {left, right, A[left]};
			
		}
		else {
			int mid = (left+right)/2;
			
			// 递归查找左边部分子数组的最大子数组
			int[] res = findMaxSubArray(A, left,  mid);
			left_low_index = res[0];
			left_high_index = res[1];
			left_max_sum = res[2];
			System.out.println(left+"+"+right+"/2="+mid);
			// 递归查找右边部分子数组的最大子数组
			res = findMaxSubArray(A, mid+1,  right);
			right_low_index = res[0];
			right_high_index = res[1];
			right_max_sum = res[2];
			// 递归查找中间部分子数组的最大子数组
			res = findMaxCrossSubarray(A, left,  mid, right);
			center_low_index = res[0];
			center_high_index = res[1];
			center_max_sum = res[2];
			
			
			if(left_max_sum>=right_max_sum && left_max_sum>=center_max_sum)
			{
				return new int[] {left_low_index, left_high_index, left_max_sum};
			}else if(right_max_sum>=left_max_sum && right_max_sum>=center_max_sum){
				return new int[] {right_low_index, right_high_index, right_max_sum};
			}else {
				return new int[] {center_low_index, center_high_index, center_max_sum};
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {-1,3,-4,2,5,-3,4,7,0,1,-1,3,7,9,-20};
		int[] res = findMaxSubArray(A, 0, A.length-1);
		System.out.println(Arrays.toString(res));
	}
}
