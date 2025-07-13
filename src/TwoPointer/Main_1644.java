package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1644 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[N+1];

		for(int i = 2; i <= N; i++) isPrime[i] = true;
		
		for(int i = 2; i*i <= N; i++) {
			if(isPrime[i]) {
				for(int j = i*i; j <= N; j+=i) isPrime[j] = false;
			}
		}
		
		ArrayList<Integer> primes = new ArrayList<>();
		
		for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
		
		int start = 0, end = 0, sum = 0, count = 0;
		while(true) {
			if(sum >= N) {
				sum -= primes.get(start);
				start++;
			}
			else if(end == primes.size()) {
				break;
			}
			else {
				sum += primes.get(end);
				end++;
			}
			
			if(sum == N) count++;
		}
		
		System.out.println(count);
		
		br.close();
	}
}
