package com.leetcode.practice.oct8;
import java.util.HashMap;

/**  

* <p>Title: Three_lengthOfLongestSubstring.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2020 like_czw@gmail.com</p>  

* <p>Company: UESTC</p>  

* @author Ke Li 

* @date 2020Äê10ÔÂ13ÈÕ  

* @version 1.0  

*/  


//Given a string s, find the length of the longest substring without repeating characters.


public class Three_lengthOfLongestSubstring {
	
	/**
	 * Utilize a slide window to addrress this problem
	 * A hashmap is used to accelerate search
	 * @param s
	 * @return
	 */
	public static int solution(String s)
	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int repeatIndex = 0;
		int currentIndex = 0;
		int maxLen = 0;
		while(currentIndex<s.length())
		{
			char val = s.charAt(currentIndex);
			if(map.containsKey(val))
			{
				repeatIndex = map.get(val);
				map = new HashMap<Character, Integer>();
				currentIndex = repeatIndex + 1;
			}else {
				map.put(val,currentIndex);
				maxLen = (map.size()>maxLen)?map.size():maxLen;
				currentIndex ++;
			}
		}
		return maxLen;
	}
	
	// test
	public static void main(String[] args) {
		System.out.println(solution("ab cd"));
	}
}
