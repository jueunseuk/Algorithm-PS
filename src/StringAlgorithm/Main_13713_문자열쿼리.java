package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_13713_문자열쿼리 {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        StringBuilder S = new StringBuilder(br.readLine()).reverse();
        int n = S.length();
        
        int query = Integer.parseInt(br.readLine());

        int[] Z = new int[n];
        Z[0] = n;
        
        int L = 0, R = 0;
        for (int i = 1; i < n; i++) {
            if (i <= R) {
                Z[i] = Math.min(R - i + 1, Z[i - L]);
            }

            while (i + Z[i] < n && S.charAt(Z[i]) == S.charAt(i + Z[i])) {
                Z[i]++;
            }

            if (i + Z[i] - 1 > R) {
                L = i;
                R = i + Z[i] - 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < query; i++) {
        	sb.append(Z[n-Integer.parseInt(br.readLine())]).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }
}
