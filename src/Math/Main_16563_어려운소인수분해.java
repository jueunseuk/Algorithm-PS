package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_16563_어려운소인수분해 {
    static final int MAX = 5000000;
    static int[] spf = new int[MAX + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        getSPF();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int comp = Integer.parseInt(st.nextToken());
            
            while(comp > 1) {
                int factor = spf[comp];
                while(comp % factor == 0) {
                    sb.append(factor).append(" ");
                    comp /= factor;
                }
            }
            
            if(sb.length() > 0 && sb.charAt(sb.length()-1) == ' ') {
                sb.deleteCharAt(sb.length()-1);
            }
            
            sb.append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
    }

    private static void getSPF() {
        for (int i = 0; i <= MAX; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i <= MAX; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= MAX; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }
}
