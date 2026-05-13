package leetcode;

public class Solution_7_ReverseInteger {
	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(reverse(120));
		System.out.println(reverse(-120));
		System.out.println(reverse(1009));
		System.out.println(reverse(10001));
		System.out.println(reverse(0));
		System.out.println(reverse(1534236469));
		
	}
	
	public static int reverse(int x) {
        String n = String.valueOf(x);
        
        if(x == 0) {
        	return 0;
        }
        
        StringBuilder sb = new StringBuilder();
        if(n.charAt(0) == '-') {
        	sb.append("-");
        }
        
        int idx = n.length()-1;
        while(true) {
        	if(n.charAt(idx) == '0') {
        		idx--;
        	} else {
        		break;
        	}
        }
        
        for(int i = idx; i > 0; i--) {
        	sb.append(n.charAt(i));
        }
        
        if(n.charAt(0) != '-') {
        	sb.append(n.charAt(0));
        }
		
        try {
        	return Integer.parseInt(sb.toString());        	
        } catch(NumberFormatException e) {
        	return 0;
        }
    }
}
