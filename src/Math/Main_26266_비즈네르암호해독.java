package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_26266_비즈네르암호해독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] origin = br.readLine().toCharArray();
        char[] password = br.readLine().toCharArray();

        int n = origin.length;
        int[] mid = new int[n];

        for (int i = 0; i < n; i++) {
            int calc = password[i] - origin[i];
            if (calc < 0) {
                calc += 26;
            }
            mid[i] = calc;
        }

        int period = findPeriod(mid);

        char[] result = new char[period];
        for (int i = 0; i < period; i++) {
            if (mid[i] == 0) {
                result[i] = 'Z';
            } else {
                result[i] = (char) ('A' + mid[i] - 1);
            }
        }

        System.out.println(new String(result));
    }

    private static int findPeriod(int[] mid) {
        int n = mid.length;
        int[] pi = prefixFunction(mid);

        int len = n - pi[n - 1];
        if (n % len == 0) {
            return len;
        }
        return n;
    }

    private static int[] prefixFunction(int[] mid) {
        int n = mid.length;
        int[] pi = new int[n];
        int j = 0;

        for (int i = 1; i < n; i++) {
            while (j > 0 && mid[i] != mid[j]) {
                j = pi[j - 1];
            }

            if (mid[i] == mid[j]) {
                pi[i] = ++j;
            } else {
                pi[i] = 0;
            }
        }
        return pi;
    }
}
