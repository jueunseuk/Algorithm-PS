package Math.Prime;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_6588_골드바흐의추측 {
	static boolean[] prime = new boolean[1000001];

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        preprocess();
        
        StringBuilder sb = new StringBuilder();
        while(true) {
        	int input = Integer.parseInt(br.readLine());
        	
        	if(input == 0) break;
        	
        	int a = 2;
        	int b = input-2;
        	
        	while(a <= b) {
        		if(prime[a] && prime[b]) {
        			sb.append(input+" = "+a+" + "+b+"\n");
        			break;
        		}
        		a++; b--;
        	}
        }

        System.out.println(sb.toString().trim());
	}

	private static void preprocess() {
		Arrays.fill(prime, true);
		
		prime[0] = false;
		prime[1] = false;
		
		for(int i = 2; i < Math.sqrt(1000001); i++) {
			for(int j = i*i; j < 1000001; j += i) {
				if(prime[j]) {
					prime[j] = false;
				}
			}
		}
	}
}