package leetcode;

import java.util.Arrays;

public class Solution_2217_FPWFL {
	public static void main(String[] args) {
		int[] arr = new int[] {58,29,358732919,149198876,246393513,104605183,18363825};
		System.out.println(Arrays.toString(kthPalindrome(arr, 9)));
	}
	
	public static long[] kthPalindrome(int[] queries, int intLength) {
		long[] result = new long[queries.length];
		
		long cri = 9 * (long) Math.pow(10, (intLength - 1) / 2);
		System.out.println(cri);
		for(int i = 0; i < queries.length; i++) {
			if(queries[i] > cri) {
				result[i] = -1;
			} else {
				long base = 0;
				if(intLength % 2 == 0) {
					base += Math.pow(10, intLength/2-1);
				} else {
					base += Math.pow(10, intLength/2);
				}
				
				base += queries[i]-1;
				
				StringBuilder first = new StringBuilder(String.valueOf(base));
				StringBuilder last = new StringBuilder(first).reverse();
				
				if(intLength % 2 == 0) {
					result[i] = Long.parseLong(first.toString()+last.toString());
				} else {
					last = last.deleteCharAt(0);
					result[i] = Long.parseLong(first.toString()+last.toString());
				}
			}
		}
		
		return result;
    }
}
