package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11947_이런반전이 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	String str = br.readLine();
        	int N = Integer.parseInt(str);
        	
        	long gn = 5 * (long) Math.pow(10, str.length() - 1) - 1;
            if (N >= gn) {
                sb.append(gn * (gn + 1)).append("\n");
            } else {
                int origin = N;
                long digit = 1;
                long other = 0;
                while (N > 0) {
                    long a = N % 10;
                    other += (9 - a) * digit;
                    digit *= 10;
                    N /= 10;
                }
                sb.append(origin * other).append("\n");
            }
        }
        
        System.out.println(sb.toString().trim());
	}
}