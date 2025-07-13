package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629_반복패턴 {
    
    public static int[] computeZArray(String s) {
        int n = s.length();
        int[] Z = new int[n];
        int L = 0, R = 0;
        
        for (int i = 1; i < n; i++) {
            if (i <= R) {
                int k = i - L;
                Z[i] = Math.min(R - i + 1, Z[k]);
            }
            while (i + Z[i] < n && s.charAt(Z[i]) == s.charAt(i + Z[i])) {
                Z[i]++;
            }
            if (i + Z[i] - 1 > R) {
                L = i;
                R = i + Z[i] - 1;
            }
        }
        return Z;
    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
        String S = br.readLine();

        int[] Z = computeZArray(S);

        int answer = 0;

        for (int L = N; L >= 1; L--) {
            boolean isPeriod;
            
            if (L == N) {
                isPeriod = true;
            } else {
                isPeriod = (Z[L] >= (N - L));
            }

            if (!isPeriod) {
                continue;
            }

            int m = (N + L - 1) / L;
            if (m < 2) m = 2;
            int totalLen = m * L;
            int need = totalLen - N;

            if (need <= K) {
                answer = L;
                break;
            }
        }
        
        System.out.println(answer);
    }
}