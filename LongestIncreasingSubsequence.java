package BinarySearch;

import java.util.Arrays;

/*
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary
 * for you to return the length. Your algorithm should run in O(n2) complexity. Follow up: Could you improve it to O(n log n) time complexity?
 * Explanation and Code from: Approach #4 Dynamic Programming with Binary Search[Accepted]: https://leetcode.com/problems/longest-increasing-subsequence/solution/
 * Time complexity : O(nlog(n)); Binary search takes log(n) time and it is called n times.
 * Space complexity : O(n); dp array of size n is used
 * Microsoft
 * Medium
 */

public class LongestIncreasingSubsequence {

	/*
	 Note: Arrays.binarySearch() method returns index of the search key, if it is contained in the array, else it returns (-(insertion point) - 1).
	 The insertion point is the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length
	 if all elements in the array are less than the specified key.
	 */
	
	public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        
        System.out.println("nums: "+Arrays.toString(nums));
        System.out.println("dp: "+Arrays.toString(dp));
        
        for(int num : nums) {
        	System.out.println("num: "+num+" len: "+len);
           
        	int i = Arrays.binarySearch(dp, 0, len, num);
            System.out.println("i: "+i);
            
        	if (i < 0) {
                i = -(i + 1);
            }
        	System.out.println("i: "+i);
        	
            dp[i] = num;
            System.out.println("dp: "+Arrays.toString(dp));
            
            if (i == len) {
                len++;
            }
            
            System.out.println("len: "+len);
        }
        return len;
    }
	
	public static int lengthOfLIS1(int[] nums) {
	    int[] tails = new int[nums.length];
	    int size = 0;
	    System.out.println("nums: "+Arrays.toString(nums));
	    
	    for(int x : nums) {
	        int i = 0, j = size;
	        System.out.println("x: "+x+" size: "+size);
	        
	        while (i != j) {
	        	System.out.println("i: "+i+" j: "+j);
	            int m = (i + j) / 2;
	            System.out.println("m: "+m+" tails[m]: "+tails[m]);
	            
	            if (tails[m] < x)
	                i = m + 1;
	            else
	                j = m;
	            
	            System.out.println("i: "+i+" j: "+j);
	        }
	        
	        tails[i] = x;
	        
	        System.out.println("tails: "+Arrays.toString(tails));
	        
	        if (i == size) 
	        	++size;
	    }
	    return size;
	}

	
	public static void main(String[] args) {
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(lengthOfLIS1(nums));
	}

}
