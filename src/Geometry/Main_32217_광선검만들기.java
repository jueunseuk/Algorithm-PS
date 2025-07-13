package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_32217_광선검만들기 {
	static int dp[] = {0, 0, 180, 360, 540, 720, 900, 1080, 1260, 1440, 1620, 1800, 1980, 2160, 2340, 2520, 2700, 2880, 3060, 3240, 3420, 3600, 3780, 3960, 4140, 4320, 4500, 4680, 4860, 5040, 5220, 5400, 5580, 5760, 5940, 6120, 6300, 6480, 6660, 6840, 7020, 7200, 7380, 7560, 7740, 7920, 8100, 8280, 8460, 8640, 8820, 9000, 9180, 9360, 9540};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;
        for(int i = 0; i < n; i++) {
        	sum += Integer.parseInt(st.nextToken());
        }
        
        sum <<= 1;
        
        System.out.println(dp[n]-sum);
	}

}
