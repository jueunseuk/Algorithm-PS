package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_30458_팰린드롬애너그램 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char[] cnt = new char[26];
		
		char[] input = br.readLine().toCharArray();
		for(int i = 0; i < n; i++) {
			cnt[input[i]-'a']++;
		}
		
		if(n % 2 == 1) {
			cnt[input[n/2]-'a']--;
		}
		
		for(int i = 0; i < 26; i++) {
			if(cnt[i] % 2 == 1) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
	}
}