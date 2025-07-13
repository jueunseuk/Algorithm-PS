package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int dp1[][] = new int[n][2];
		int dp2[][] = new int[n][2];
		int dp3[][] = new int[n][2];
		
		int input[][] = new int[n][3];
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			input[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp1[0][0] = input[0][0];
		dp1[0][1] = 0;
		
		dp2[0][0] = input[0][1];
		dp2[0][1] = 1;
		
		dp3[0][0] = input[0][2];
		dp3[0][1] = 2;
		
		for (int i = 1; i < n; i++) {
            dp1[i][0] = input[i][0] + Math.min(dp2[i - 1][0], dp3[i - 1][0]);
            dp2[i][0] = input[i][1] + Math.min(dp1[i - 1][0], dp3[i - 1][0]);
            dp3[i][0] = input[i][2] + Math.min(dp1[i - 1][0], dp2[i - 1][0]);
        }

        int result = Math.min(dp1[n - 1][0], Math.min(dp2[n - 1][0], dp3[n - 1][0]));
        System.out.println(result);
	}

}
