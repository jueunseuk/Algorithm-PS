package BinarySearch;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1300_K번째수 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        long k = Long.parseLong(br.readLine());
        long low = 1, high = k;
        
		while(low < high) {
			long mid = (low + high) / 2;
			long cnt = 0;
			
			for(int i = 1; i <= n; i++) {
				cnt += Math.min(mid / i, n);
			}
			
			if(k <= cnt) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
				
		System.out.println(low);

	}
}
