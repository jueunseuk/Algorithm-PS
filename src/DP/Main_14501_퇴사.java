package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int day = Integer.parseInt(br.readLine());
        
        int plan[][] = new int[day+1][2];
        int dp[] = new int[day+2];
        
        StringTokenizer st;
        for(int i = 1; i <= day; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	plan[i][0] = Integer.parseInt(st.nextToken());
        	plan[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = day; i >= 1; i--) {
            if (i + plan[i][0] <= day + 1) {
                dp[i] = Math.max(dp[i + 1], plan[i][1] + dp[i + plan[i][0]]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
       
        System.out.println(dp[1]);
	}
}
