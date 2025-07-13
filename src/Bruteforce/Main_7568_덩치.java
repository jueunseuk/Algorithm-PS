package Bruteforce;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7568_덩치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int input [][] = new int[n][2];
		
		int result[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(j!=i) {
					if(input[i][0] < input[j][0] && input[i][1] < input[j][1]) {
						result[i]++;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int out : result) {
			sb.append(out+1).append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}

}
