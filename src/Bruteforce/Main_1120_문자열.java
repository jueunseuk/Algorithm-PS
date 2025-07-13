package Bruteforce;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1120_문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String a = st.nextToken();
		String b = st.nextToken();
		
		int min = Integer.MAX_VALUE;
		int t = b.length() - a.length();
		
		for(int i = 0; i <= t; i++) {
			int curr = 0;
			StringBuilder copy = new StringBuilder(b);
			
			copy.replace(i, i+a.length(), a);
			
			for(int j = 0; j < b.length(); j++) {
				if(copy.charAt(j) != b.charAt(j)) {
					curr++;
				}
			}
			
			min = Math.min(curr, min);
		}
		
		System.out.println(min);
	}
}