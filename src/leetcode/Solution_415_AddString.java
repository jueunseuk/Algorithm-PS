package leetcode;

public class Solution_415_AddString {
	public String addStrings(String num1, String num2) {
		char[] n1 = num1.toCharArray();
		char[] n2 = num2.toCharArray();
		
		int r1 = n1.length-1;
		int r2 = n2.length-1;
		
		StringBuilder sb = new StringBuilder();
		
		int car = 0;
		while(true) {
			if(r1 < 0 || r2 < 0) break;
			
			int sum = (n1[r1]-'0') + (n2[r2]-'0');
			sb.insert(0, car + sum % 10);
			car = sum / 10;
			
			r1--; r2--;
		}
		
		if(r1 >= 0) {
			for(int i = r1; i >= 0; i--) {
				int sum = n1[i] + car;
				sb.insert(0, sum % 10);
				car = sum / 10;
			}
		} else if(r2 >= 0) {
			for(int i = r2; i >= 0; i--) {
				int sum = n2[i] + car;
				sb.insert(0, sum % 10);
				car = sum / 10;
			}
		}
		
		if(car > 0) sb.insert(0, 1);
		
        return sb.toString();
    }
}
