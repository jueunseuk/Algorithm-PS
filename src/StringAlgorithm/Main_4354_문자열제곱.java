package StringAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4354_문자열제곱 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String pattern = br.readLine();
			
			if(pattern.equals(".")) {
				break;
			}
			
			int[] pi = getPi(pattern);
			int len = pattern.length();
            int unit = len - pi[len - 1];
            
            if (len % unit == 0) {
                sb.append(len / unit).append("\n");
            } else {
                sb.append(1).append("\n");
            }
		}
		
		System.out.println(sb.toString().trim());
	}

	private static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		
		for(int i = 1; i < pattern.length(); i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
}