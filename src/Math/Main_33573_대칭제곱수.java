package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_33573_대칭제곱수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringBuilder input = new StringBuilder(br.readLine());
			
			long num = Long.parseLong(input.toString());
			long reverse = Long.parseLong(input.reverse().toString());
			
			double sqrt = Math.sqrt(num);
			if(sqrt - (long) sqrt > 0.00000001) {
				sb.append("NO\n");
				continue;
			}
			
			sqrt = Math.sqrt(reverse);
			if(sqrt - (long) sqrt > 0.00000001) {
				sb.append("NO\n");
				continue;
			}
			
			sb.append("YES\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}