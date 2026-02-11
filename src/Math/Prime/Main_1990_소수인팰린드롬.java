package Math.Prime;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1990_소수인팰린드롬 {
    static final int MAX = 10000000;
    static boolean[] prime = new boolean[MAX + 1];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        b = Math.min(10000000, b);

        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        
        for (int i = 2; i * i <= MAX; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    prime[j] = false;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = a; i <= b; i++) {
            if (prime[i] && isPal(i)) {
            	sb.append(i+"\n");
            }
        }
        
        if(sb.length() > 0) System.out.println(sb.toString().trim());
        System.out.println(-1);
    }
    
    private static boolean isPal(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}