package BinarySearch;

import java.util.PriorityQueue;

/*
 	378. Kth Smallest Element in a Sorted Matrix
	https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
	Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
	Note that it is the kth smallest element in the sorted order, not the kth distinct element.
	Example:
	matrix = [
	   [ 1,  5,  9],
	   [10, 11, 13],
	   [12, 13, 15]
	],
	k = 8,
	return 13.
	Note: You may assume k is always valid, 1 ≤ k ≤ n2.
	Code and Explanation from: @YuanGao https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code?page=2
	https://translate.google.com/translate?hl=en&sl=zh-CN&u=https://aaronice.gitbooks.io/lintcode/content/data_structure/kth_smallest_number_in_sorted_matrix.html&prev=search
	Time Complexity: The above solution involves following steps.
	1) Build a min heap which takes O(n) time
	2) Heapify k times which takes O(kLogn) time.
	Therefore, overall time complexity is O(n + kLogn) time.
	Google, Twitter, Amazon
 */

/*
 Solution 1 : Heap
Here is the step of my solution:

Build a minHeap of elements from the first row.
Do the following operations k-1 times :
Every time when you poll out the root(Top Element in Heap), you need to know the row number and column number of that element(so we can create a tuple class here), replace that root with the next element from the same column.
After you finish this problem, thinks more :

For this question, you can also build a min Heap from the first column, and do the similar operations as above.(Replace the root with the next element from the same row)
What is more, this problem is exact the same with Leetcode373 Find K Pairs with Smallest Sums, I use the same code which beats 96.42%, after you solve this problem, you can check with this link:
https://discuss.leetcode.com/topic/52953/share-my-solution-which-beat-96-42

 */

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    
    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
}

public class KthSmallestElementInASortedMatrix {
	
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        
        System.out.println("n: "+n);
        
        for(int j=0; j <= n-1; j++) { 
        	pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        
        System.out.println("pq: "+pq);
        
        for(int i=0; i<k-1; i++) {
        	System.out.println("i: "+i);
        	
            Tuple t = pq.poll();
            System.out.println("t: "+t.val+" t.x: "+t.x+" t.y: "+t.y+" n-1: "+(n-1));
            
            if(t.x == n-1) {
            	System.out.println("in continue");
            	continue;
            }
            
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {
							{ 1,  5,  9},
		                  	{10, 11, 13},
		                  	{14, 15, 16}
						};
		int k = 8;
		
		System.out.println(kthSmallest(matrix, k));
	}

}