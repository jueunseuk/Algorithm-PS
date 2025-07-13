package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3036_링 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int input[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        
        int basis = input[0];
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n; i++) {
        	int div;
        	if(input[i] > basis) {
        		div = gcd(input[i], basis);
        	} else {
        		div = gcd(basis, input[i]);
        	}
        	
        	sb.append(basis/div).append("/").append(input[i]/div).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}