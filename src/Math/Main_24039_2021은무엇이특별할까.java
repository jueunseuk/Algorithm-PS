package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_24039_2021은무엇이특별할까 {
	static final int MAX = 200;
	static boolean prime[] = new boolean[MAX+1];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		pre();
		
		int input = Integer.parseInt(br.readLine());
		
		int left = 2;
		int right = 3;
		while(right <= MAX) {
			if(!prime[left]) {
				while(!prime[left]) {
					left++;
				}
				right = left+1;
				while(!prime[right]) {
					right++;
				}
			}
			if(!prime[right]) {
				while(!prime[right]) {
					right++;
				}
			}
			
			if(left*right > input) {
				System.out.println(left*right);
				break;
			} else {
				left++;
				right++;
			}
		}
		
	}

	private static void pre() {
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		
		int limit = (int) Math.sqrt(MAX);
		for(int i = 2; i <= limit; i++) {
			for(int j = i*i; j <= MAX; j+=i) {
				if(prime[j]) {
					prime[j] = false;
				}
			}
		}
	}
}