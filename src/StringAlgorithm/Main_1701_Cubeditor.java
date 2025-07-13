package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1701_Cubeditor {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int max = 0;
		
		for(int i = 0; i < str.length(); i++) {
			int []pi = new int[str.length()];
			String substr = str.substring(i);
			max = Math.max(pi(substr, pi, max), max);
		}
		
		System.out.println(max);
	}
	
	public static int pi(String pattern, int[] pi, int max) {
		int j = 0;
		int length = pattern.length();
		
		for(int i = 1; i < length; i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(j)) {
				j++;
				pi[i] = j;
			}
			
			max = Math.max(max, pi[i]);
		}
		
		return max;
	}

}
