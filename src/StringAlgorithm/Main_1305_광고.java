package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1305_광고 {
	static int pi[];
	static int maxLength = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String text = br.readLine();
		
		pi(text);
		
		System.out.println(text.length()-pi[text.length()-1]);
		
	}

	public static void pi(String pattern) {
		int length = pattern.length();
		pi = new int[length];
		int j = 0;
		
		for(int i = 1; i < length; i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
				maxLength = Math.max(maxLength, pi[i]);
			}
		}
	}
}
