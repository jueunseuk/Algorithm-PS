package leetcode;

public class Solution_8_StringtoInteger {
	public static void main(String[] args) {
		System.out.println(myAtoi("+100"));
		System.out.println(myAtoi("-0100"));
		System.out.println(myAtoi("+0100"));
		System.out.println(myAtoi("0-1"));
	}
	
	public static int myAtoi(String s) {
	    int i = 0;
	    int n = s.length();

	    while (i < n && s.charAt(i) == ' ') {
	        i++;
	    }

	    int sign = 1;
	    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
	        if (s.charAt(i) == '-') {
	            sign = -1;
	        }
	        i++;
	    }

	    int result = 0;

	    while (i < n && Character.isDigit(s.charAt(i))) {
	        int digit = s.charAt(i) - '0';

	        if (result > (Integer.MAX_VALUE - digit) / 10) {
	            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	        }

	        result = result * 10 + digit;
	        i++;
	    }

	    return result * sign;
	}
}
