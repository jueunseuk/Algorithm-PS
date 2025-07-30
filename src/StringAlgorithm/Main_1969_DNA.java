package StringAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1969_DNA {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[] dna = new String[n];
		for(int i = 0; i < n; i++) {
			dna[i] = br.readLine();
		}
		
		int diff = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			int[] cnt = new int[26];
			for(int j = 0; j < n; j++) {
				cnt[dna[j].charAt(i)-'A']++;
			}
			
			int idx = -1;
			int max = 0;
			for(int j = 0; j < 26; j++) {
				if(max < cnt[j]) {
					max = cnt[j];
					idx = j;
				}
			}
			
			idx += 'A';
			sb.append((char) idx);
			
			diff += n-max;
		}
		
		System.out.println(sb.toString().trim());
		System.out.println(diff);
	}
}