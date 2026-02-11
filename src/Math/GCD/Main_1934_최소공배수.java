package Math.GCD;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1934_최소공배수 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if(a % b == 0) {
        		sb.append(a+"\n");
        		continue;
        	} else if(b % a == 0) {
        		sb.append(b+"\n");
        		continue;
        	}
        	
        	int result;
        	if(a >= b) {
        		result = a*b/gcd(a ,b);
        	} else {
        		result = a*b/gcd(b, a);
        	}
        	
        	sb.append(result+"\n");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
}