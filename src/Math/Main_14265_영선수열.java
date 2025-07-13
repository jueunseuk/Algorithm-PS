package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14265_영선수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " "	);
		
		long k = Long.parseLong(st.nextToken());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken())+1;
		
		long temp = k;
		
		if(k == 0) {
			System.out.println(b-a);
			return;
		}
		
		long k1 = k, kk = k+1;
		long ans = 0;
		while(k1 < b) {
			if(a < kk) {
				long left = Math.max(a, k1);
				long right = Math.min(b, kk);
				
				if(left < right) {
					ans += right - left;
				}
			}
			
			k1 <<= 1;
			kk <<= 1;
		}
		
		if(temp % 2 == 0) {
			k1 = temp+1;
			kk = temp+2;
			
			while(k1 < b) {
				if(a < kk) {
					long left = Math.max(a, k1);
					long right = Math.min(b, kk);
					
					if(left < right) {
						ans += right - left;
					}
				}
				
				k1 <<= 1;
				kk <<= 1;
			}
		}
		
		System.out.println(ans);
	}
}