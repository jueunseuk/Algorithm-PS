package Math.Prime;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1747_소수와팰린드롬 {
    static final int MAX = 1003001;
    static boolean[] prime = new boolean[MAX + 1];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        
        for (int i = 2; i * i <= MAX; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    prime[j] = false;
                }
            }
        }
        
        for (int i = n; i <= MAX; i++) {
            if (prime[i] && isPal(i)) {
                System.out.println(i);
                return;
            }
        }
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