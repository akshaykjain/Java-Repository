import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	// 1
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++){
			if (map.containsKey(target - nums[i])) {
				result[1] = i;
				result[0] = map.get(target - nums[i]);
				return result;
			}
			map.put(nums[i], i);
		}
		return result;
	}

	// 2
	public static int reverse(int x) {
		long result = 0;
		while (x != 0)
		{
			result *= 10;
			result += x % 10;
			x/=10;    
		}
		if (Integer.MIN_VALUE > result || Integer.MAX_VALUE < result)
			return 0;
		return (int) result;
	}

	// 3
	public static boolean isPalindrome(int x) 
	{
		if (x < 0)
			return false;
		long reverseLong = 0;
		int reverseInt = 0;
		int arg = x;
		while (x != 0) {
			reverseLong *= 10;
			reverseLong += x % 10;
			x/=10;    
		}
		if (Integer.MAX_VALUE < reverseLong)
			reverseInt = 0;
		else
			reverseInt = (int) reverseLong;
		if (arg == reverseInt)
			return true;
		else 
			return false;
	} 
	// 4
	public static int removeDuplicates(int[] nums) {
		int i = 1 ;
		for(int j = 1; j < nums.length; j++) {
			if(nums[j] != nums[j - 1]) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
	//	 5
	public static int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; ++i) {
			int diff = prices[i] - prices[i-1];
			if (diff > 0) {
				profit += diff;
			}
		}
		return profit;
	}
	// 6
	public static int[] rotate(int[] nums, int k) {
		int []result = new int[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			result[(i+k) % nums.length] = nums[i];        
		}
		return result;
	}

	// 7
	public static boolean containsDuplicate(int[] nums) {
		if (nums.length < 2)
			return false;
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] == nums[i-1]) {
				return true;
			}
		}
		return false;
	}

	// 8
	public static int singleNumber(int[] nums) {
		int singleForever = 0;
		for (int i:nums) {
			singleForever = singleForever ^ i;
		}
		return singleForever;
	}

	// 9
	public static int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		for (int i : nums1) {
			if (map.containsKey(i))
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 1);
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int j : nums2) {
			if (map.containsKey(j) && map.get(j) > 0) {
				map.put(j, map.get(j) - 1);
				list.add(j);
			}
		}

		int []result = new int[list.size()];
		for(int k = 0; k < list.size(); k++)
		{
			result[k] = list.get(k);
		}
		return result;
	}

	// 10
	public static int[] plusOne(int[] digits) {
		int n = digits.length;
		for (int i = digits.length - 1; i >= 0; --i) {
			if (digits[i] < 9) {
				++digits[i];
				return digits;
			}
			digits[i] = 0;
		}
		int[] res = new int[n + 1];
		res[0] = 1;
		return res;
	}

	// 11
	public static int[] moveZeroes(int[] nums) {
		int a = 0;
		int k = 0;
		while(k < nums.length) {
			if (nums[k] == 0)
				++k;
			else {
				nums[a] = nums[k];
				++a;
				++k;
			}	
		}
		while(a < nums.length) {
			nums[a] = 0;
			++a;
		}
		return nums;
	}

	// 12
	public static String reverseString(String s) {
		char[] result = s.toCharArray();
		int first = 0;
		int last = s.length() - 1;
		while(first < last) {
			char temp = result[first];
			result[first] = result[last];
			result[last] = temp;
			++first;
			--last;
		}
		return new String(result);
	}

	// 13
	public static int firstUniqChar(String s) {
		int[] arr = new int[26];
		for(char c : s.toCharArray()) {
			arr[c - 'a']++;
		}
		for(int i = 0;i<s.length();i++) {
			if(arr[s.charAt(i) - 'a'] == 1) 
				return i;
		}
		return -1;
	}

	// 14
	public static boolean isAnagram(String s, String t) {
		if (s.isEmpty() == true && t.isEmpty() == true)
			return true;
		if (s.isEmpty() != t.isEmpty() || s.length() != t.length())
			return false;

		int []score = new int [26];
		for (int i = 0; i < s.length(); ++i)
			++score[s.charAt(i) - 'a'];
		for (int j = 0; j < t.length(); ++j)
			--score[t.charAt(j) - 'a'];

		for (int k : score) {
			if (k != 0)
				return false;
			else
				continue;
		}
		return true;
	}

	// 15
	public static boolean isPalindrome(String s) {
		String s1 = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
		char []reverse = s1.toCharArray();
		int first = 0;
		int last = s1.length() -1;
		while (first < last) {
			char temp = reverse[first];
			reverse[first] = reverse[last];
			reverse[last] = temp;
			++first;
			--last;
		}
		String s2 = new String(reverse);
		if (s2.equals(s1))
			return true;
		return false;
	}

	// 16
	public static int myAtoi(String str) {
			if (str == null || str.length() < 1)
				return 0;
			str = str.trim();
			char flag = '+';
			int i = 0;
			if (str.charAt(0) == '-') {
				flag = '-';
				i++;
			} else if (str.charAt(0) == '+') {
				i++;
			}
			String result1 = "";
			while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				result1 += str.charAt(i);
				i++;
			}
	        double result = 0;
	        if (!result1.isEmpty())
	            result = Double.parseDouble(result1);
			if (flag == '-')
				result = -result;
			if (result > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (result < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			return (int) result;
		}
	    
	public static void main(String[] args) {

		/******************************************************************************
		 * 1. Given an array of integers, return indices of the two numbers such that they add up 
		 * to a specific target. You may assume that each input would have exactly one solution, 
		 * and you may not use the same element twice.
		 * Example:
		 * Given nums = [2, 7, 11, 15], target = 9,
		 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
		 *****************************************************************************/
		int[] nums = {2, 7,11,15};
		int target = 9;
		int[] result1 = twoSum(nums, target);
		System.out.println("1. twoSum:");
		System.out.println(result1[0] + " " + result1[1]);
		System.out.println();

		/******************************************************************************
		 * 2. Given a 32-bit signed integer, reverse digits of an integer.
		 * Example 1:
		 * Input: 123
		 * Output:  321
		 * 
		 * Example 2:
		 * Input: -123
		 * Output: -321
		 * 
		 * Example 3:
		 * Input: 120
		 * Output: 21
		 * 
		 * Note:
		 * Assume we are dealing with an environment which could only hold integers within 
		 * the 32-bit signed integer range. For the purpose of this problem, assume that 
		 * your function returns 0 when the reversed integer overflows.
		 *****************************************************************************/
		int x1 = 1534236469;
		int result2 = reverse(x1);
		System.out.println("2. reverse:");
		System.out.println(result2);
		System.out.println();

		/******************************************************************************
		 * 3. Determine whether an integer is a palindrome.
		 *****************************************************************************/
		int x2 = -1;
		boolean result3 = isPalindrome(x2);
		System.out.println("3. isPalindrome:");
		System.out.println(result3);
		System.out.println();

		/******************************************************************************
		 * 4. 	Given a sorted array, remove the duplicates in-place such that each element appear 
		 * only once and return the new length. Do not allocate extra space for another array, 
		 * you must do this by modifying the input array in-place with O(1) extra memory.
		 * 
		 * Example:
		 * Given nums = [1,1,2],
		 * Your function should return length = 2, with the first two elements of nums 
		 * being 1 and 2 respectively.
		 * It doesn't matter what you leave beyond the new length.
		 *****************************************************************************/
		int arr[] = {1, 1, 2};
		int result4 = removeDuplicates(arr);
		System.out.println("4. removeDuplicates:");
		for (int i = 0; i < result4; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		System.out.println();

		/******************************************************************************
		 * 5. Say you have an array for which the ith element is the price of a given stock on 
		 * day i. Design an algorithm to find the maximum profit. You may complete as many 
		 * transactions as you like (ie, buy one and sell one share of the stock multiple times). 
		 * However, you may not engage in multiple transactions at the same time (ie, you must 
		 * sell the stock before you buy again).
		 *****************************************************************************/	
		int []prices = {1,3,4,4,1,2,3,5,7};
		int result5 = maxProfit(prices);
		System.out.println("5. maxProfit:");
		System.out.println(result5);
		System.out.println();

		/******************************************************************************
		 * 6. Rotate an array of n elements to the right by k steps.
		 * 
		 * Example:
		 * With n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
		 *****************************************************************************/	
		int []rotateThis = {1,2,3,4,5,6,7};
		int rotateBy = 3;
		int []result6 = new int[rotateThis.length];
		result6 = rotate(rotateThis, rotateBy);
		System.out.println("6. rotate:");
		for (int i = 0; i < result6.length; i++)
			System.out.print(result6[i] + " ");
		System.out.println();
		System.out.println();

		/******************************************************************************
		 * 7. Given an array of integers, find if the array contains any duplicates. 
		 * Your function should return true if any value appears at least twice in the array, 
		 * and it should return false if every element is distinct.
		 *****************************************************************************/	
		int []testArr = {1,2,2,3,4,5,6,7};
		boolean isDuplicate = containsDuplicate(testArr);
		System.out.println("7. containsDuplicate:");
		System.out.println(isDuplicate);
		System.out.println();

		/******************************************************************************
		 * 8. Given an array of integers, every element appears twice except for one. 
		 * Find that single one.
		 *****************************************************************************/
		int []testArr2 = {1,2,2,3,3,4,4};
		int result8 = singleNumber(testArr2);
		System.out.println("8. singleNumber:");
		System.out.println(result8);
		System.out.println();

		/******************************************************************************
		 * 9. Given two arrays, write a function to compute their intersection.
		 *
		 * Example:
		 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
		 *****************************************************************************/
		int []arr1 = {1,2,3};
		int []arr2 = {1,3};
		int []result9 = intersect(arr1, arr2);
		System.out.println("9. intersect:");
		for (int i = 0; i < result9.length; ++i)
			System.out.print(result9[i] + " ");
		System.out.println();
		System.out.println();

		/******************************************************************************
		 * 10. Given a non-negative integer represented as a non-empty array of digits, plus one 
		 * to the integer. You may assume the integer do not contain any leading zero, except 
		 * the number 0 itself. The digits are stored such that the most significant digit is at 
		 * the head of the list.
		 *****************************************************************************/
		int []testArr3 = {9,8,7,6,5,4,3,2,1,0};
		int []result10 = plusOne(testArr3);
		System.out.println("10. plusOne:");
		for (int i = 0; i < result10.length; ++i)
			System.out.print(result10[i] + " ");
		System.out.println();
		System.out.println();

		/******************************************************************************
		 * 11. Given an array nums, write a function to move all 0's to the end of it while 
		 * maintaining the relative order of the non-zero elements. 
		 * 
		 * Example: 
		 * Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
		 *****************************************************************************/
		int []nums2 = {0, 1, 0, 3, 12};
		int []result11 = moveZeroes(nums2);
		System.out.println("11. moveZeroes:");
		for (int i = 0; i < result11.length; ++i)
			System.out.print(result11[i] + " ");
		System.out.println();
		System.out.println();

		/******************************************************************************
		 * 12. Write a function that takes a string as input and returns the string reversed.
		 * 
		 * Example: 
		 * Given s = "hello", return "olleh".
		 *****************************************************************************/
		String word = "hello";
		String result12 = reverseString(word);
		System.out.println("12. reverseString: ");
		System.out.println(result12);
		System.out.println();

		/******************************************************************************
		 * 13. Given a string, find the first non-repeating character in it and return it's index. 
		 * If it doesn't exist, return -1.
		 * 
		 * Example 1:
		 * s = "leetcode"
		 * return 0.
		 * 
		 * Example 2:
		 * s = "loveleetcode",
		 * return 2.
		 *****************************************************************************/
		String word2 = "lovealwayssustains";
		int result13 = firstUniqChar(word2);
		System.out.println("13. firstUnique: ");
		System.out.println(result13);
		System.out.println();

		/******************************************************************************
		 * 14. Given two strings s and t, write a function to determine if t is an anagram of s.
		 * 
		 * Example:
		 * s = "anagram", t = "nagaram", return true.
		 * s = "rat", t = "car", return false.
		 *****************************************************************************/
		String s = "anagram";
		String t = "nagaram";
		boolean result14 = isAnagram(s, t);
		System.out.println("14. isAnagram:");
		System.out.println(result14);
		System.out.println();

		/******************************************************************************
		 * 15. Given a string, determine if it is a palindrome, considering only alphanumeric 
		 * characters and ignoring cases.
		 * Example:
		 * "A man, a plan, a canal: Panama" is a palindrome.
		 * "race a car" is not a palindrome.
		 *****************************************************************************/
		String s2 = "A man, a plan, a canal: Panama";
		boolean result15 = isPalindrome(s2);
		System.out.println("15. isPalindrome:");
		System.out.println(result15);
		System.out.println();

		/******************************************************************************
		 * 16. Implement atoi to convert a string to an integer.
		 *****************************************************************************/
		String s3 = "   +0 123";
		int result16 = myAtoi(s3);
		System.out.println("16. myAtoi:");
		System.out.println(result16);
		System.out.println();
	}
}
