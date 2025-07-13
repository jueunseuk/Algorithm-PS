package DivideAndConquer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4233_가짜소수 {
	static long p, a;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	p = Integer.parseInt(st.nextToken());
        	a = Integer.parseInt(st.nextToken());
        	
        	if(a == 0 && p == 0) break;
        	
        	if(!isPrime(p) && exponent(a, p) == (a % p)) {
        		sb.append("yes").append("\n");
        	} else {
        		sb.append("no").append("\n");
        	}
        }
        
        System.out.println(sb.toString().trim());

	}

	public static long exponent(long a, long p) {
		return power(a, p);
	}
	
	public static long power(long a, long exp) {
	    if (exp == 0) {
	        return 1;
	    }
	    if (exp == 1) {
	        return a % p;
	    }

	    long half = power(a, exp / 2) % p;

	    if (exp % 2 == 0) {
	        return (half * half) % p;
	    } else {
	        return ((half * half) % p * a) % p;
	    }
	}
	
	static boolean isPrime(long x) {
        if (x < 2) return false;        
        if (x == 2) return true;

        if (x % 2 == 0) {
            return true;
        }

        long limit = (long) Math.sqrt(x);
        for (long i = 3; i <= limit; i += 2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}