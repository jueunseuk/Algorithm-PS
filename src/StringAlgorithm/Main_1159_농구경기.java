package StringAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1159_농구경기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[26];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			cnt[str.charAt(0)-'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 26; i++) {
			if(cnt[i] > 4) {
				sb.append((char)('a'+i));
			}
		}
		
		if(sb.length() == 0) {
			System.out.println("PREDAJA");
		} else {
			System.out.println(sb.toString().trim());
		}
	}
}