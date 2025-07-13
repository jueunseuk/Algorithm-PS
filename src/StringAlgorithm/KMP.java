package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KMP {
	static StringBuilder sb;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String text = br.readLine();
		String pattern = br.readLine();
		
		kmp(text, pattern);
		
		System.out.println(cnt);
		System.out.println(sb.toString().trim());
		
	}
	
	public static void kmp(String text, String pattern) {
		cnt = 0;
		int pi[] = create(pattern);
		int j = 0;
		sb = new StringBuilder();
		
		for(int i = 0; i < text.length(); i++) {
			
			while(j > 0 && text.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			
			if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                	sb.append(i - pattern.length() + 2).append(" ");
                	cnt++;
                    j = pi[j];
                } else {
                    j++;
                }
            }
		}
	}
	
	public static int[] create(String pattern) {
		int length = pattern.length();
		int []pi = new int[length];
		int j = 0; // 현재 최대 공통 문자열 길이
		
		for(int i = 1; i < length; i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(j)) {
				j++;
				pi[i] = j;
			}
		}
		
		return pi;
	}

}
