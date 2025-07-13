package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2581_소수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean is[] = new boolean[N+1];
		
		Arrays.fill(is, true);
		is[1] = false;
		
		for (int i = 2; i * i <= N; i++) {
            if (is[i]) {
                for (int j = i * i; j <= N; j += i) {
                    is[j] = false;
                }
            }
        }
		
		int sum = 0;
		int first = 0;
		
		for(int i = M; i <= N; i++) {
			if(is[i]) {
				if(first == 0) {
					first = i;
				}
				sum += i;
			}
		}
		
		if(sum != 0) {
			System.out.println(sum);
			System.out.println(first);
		} else {
			System.out.println(-1);
		}

	}

}
