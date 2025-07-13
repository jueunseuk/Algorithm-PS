package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14698_슬라임 {
	static final int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int t = 0; t < T; t++) {
        	int n = Integer.parseInt(br.readLine());
        	
        	Queue<BigInteger> q = new PriorityQueue<>();
        	
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int i = 0; i < n; i++) {
        		q.add(new BigInteger(st.nextToken()));
        	}
        	
        	if(n < 2) {
        		System.out.println(1);
        		continue;
        	}
        	
        	long result = 1;
        	
        	while(q.size() > 1) {
                BigInteger a = q.poll();
                BigInteger b = q.poll();

                BigInteger merged = a.multiply(b);

                long energy = merged.mod(BigInteger.valueOf(MOD)).longValue();
                result = (result * energy) % MOD;

                q.add(merged);
            }
        	
        	System.out.println(result);
        }

	}

}
