package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1011_FlymetotheAlphaCentauri {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			y -= x;
			
			int max = (int) Math.sqrt(y);
			if(max == Math.sqrt(y)) sb.append(max*2-1).append("\n");
			else if(y <= max*max + max) sb.append(max*2).append("\n");
			else sb.append(max*2+1).append("\n");
		}

		System.out.println(sb.toString().trim());
	}
}