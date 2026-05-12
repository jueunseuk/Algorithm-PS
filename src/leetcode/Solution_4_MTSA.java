package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_4_MTSA {
	
	public static void main(String[] args) {
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Queue<Integer> q = new PriorityQueue<>();
        
        for(int n : nums1) {
        		q.offer(n);
        }
        
        for(int n : nums2) {
        		q.offer(n);
        }
        
        int size = nums1.length + nums2.length;
        
        if(size % 2 == 0) {
        		int mid = size / 2 - 1;
        		for(int i = 0; i < mid ;i++) {
        			q.poll();
        		}
        		double avg = q.poll() + q.poll();
        		avg /= 2.0;
        		
        		return avg;
        } else {
        		int mid = size / 2;
        		for(int i = 0; i < mid ; i++) {
        			q.poll();
        		}
        		return q.poll();
        }
    }
}