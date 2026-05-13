package leetcode;

public class Solution_9_PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(Integer.MAX_VALUE));
	}
	
	public static boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}
		
		String n = String.valueOf(x);
		int right = n.length()-1;
		int left = 0;
		
		while(left < right) {
			if(n.charAt(left) == n.charAt(right)) {
				right--;
				left++;
			} else {
				return false;
			}
		}
		
		return true;
    }
}
