package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1351_무한수열 {

	static Map<Long, Long> dp = new HashMap<>();
	static long p, q;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());
        
        dp.put(0l, 1l);
        
        System.out.println(dp(n));
	}
	
	public static long dp(long n) {
		if(dp.containsKey(n)) return dp.get(n);
		
		long x = n / p;
		long y = n / q;
		dp.put(n,  dp(x)+dp(y));
		
		return dp.get(n);
	}

}
