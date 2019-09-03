package BinarySearch;

/*
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right. Integers in each column are sorted in ascending from top to bottom.
 * For example, Consider the following matrix:
 * [
 *  [1,   4,  7, 11, 15],
 *  [2,   5,  8, 12, 19],
 *  [3,   6,  9, 16, 22],
 *  [10, 13, 14, 17, 24],
 *  [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 * Explanation and Code from: Approach #4 Search Space Reduction https://leetcode.com/problems/search-a-2d-matrix-ii/solution/
 * Time complexity : O(n+m)
 * The key to the time complexity analysis is noticing that, on every iteration (during which we do not return true) either row or col is 
 * decremented/incremented exactly once. Because row can only be decremented m times and col can only be incremented n times before causing the while loop to 
 * terminate, the loop cannot run for more than n+m iterations. Because all other work is constant, the overall time complexity is linear in the sum of the 
 * dimensions of the matrix.
 * Space complexity : O(1), Because this approach only manipulates a few pointers, its memory footprint is constant.
 * Note: This would work equally well with a pointer initialized to the top-right. Neither of the other two corners would work, as pruning a row/column might prevent us from achieving the correct answer.
 * Google, Amazon, Apple
 * Medium
 */

public class Search2DMatrix2 {

	public static boolean searchMatrix(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length - 1;
        int col = 0;

        System.out.println("target: "+target);
        
        while(row >= 0 && col < matrix[0].length) {
        	
        	System.out.println("row: "+row+" col: "+col);
        	System.out.println("matrix[row][col]: "+matrix[row][col]+" target: "+target);
        	
            if (matrix[row][col] > target) {
                row--;
            } 
            else if (matrix[row][col] < target) {
                col++;
            } 
            else { // found it
                return true;
            }
        }

        return false;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {
		                  {1,   4,  7, 11, 15},
		                  {2,   5,  8, 12, 19},
		                  {3,   6,  9, 16, 22},
		                  {10, 13, 14, 17, 24},
		                  {18, 21, 23, 26, 30}
						};
		
		int target = 5;
		
		System.out.println(searchMatrix(matrix, target));
	}

}
