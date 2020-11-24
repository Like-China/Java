package com.leetcode.practice.oct8;

import java.util.HashMap;

// e.x.
// Given nums = [2, 7, 11, 15], target = 9
// return [0, 1] for nums[0] + nums[1] = 2 + 7 = 9

public class One_SumOfTwoNumber {
	/**
	 * solution 1£¬ utilize the hash map form like <currentValue, currentIndex>
	 * @param nums
	 * @param target
	 * @return indexes
	 */
	public static int[] solution1(int[] nums, int target) {
		HashMap<Integer, Integer> valueToIndexMap = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++)
		{
			// current focused value
			int curVal = nums[i];
			int residual = target-curVal;
			if(valueToIndexMap.containsKey(residual))
			{
				int index = valueToIndexMap.get(residual);
				return index>i?new int[]{i,index}:new int[] {index,i};
			}else {
				valueToIndexMap.put(curVal,i);
			}
		}
		return null;
    }
	
	
	/**
	 * brute-force, a straightforward method that uses two loops
	 * @param nums
	 * @param target
	 * @return indexes
	 */
	public static int[] solution2(int[] nums, int target)
	{
		for(int i=0;i<nums.length-1;i++)
		{
			for(int j=i+1;j<nums.length;j++)
			{
				if(nums[i]+nums[j] == target)
				{
					return new int[]{i,j};
				}
			}
		}
		return null;
	}
	
	
	
	
	/**
	 * test
	 */
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 18;
		int[] res = solution2(nums, target);
		if(res != null) {System.out.println(res[0]+" "+ res[1]);}
	}
}
