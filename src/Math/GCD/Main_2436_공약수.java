package Math.GCD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2436_공약수 {

    static long gcd(long x, long y) {
        while (y != 0) {
            long t = x % y;
            x = y;
            y = t;
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long k = b / a;
        long size = (long) Math.sqrt(k);

        long bestP = 1, bestQ = k;

        for (long p = 1; p <= size; p++) {
            if (k % p != 0) continue;
            long q = k / p;

            if (gcd(p, q) != 1) continue;

            if (q - p < bestQ - bestP) {
                bestP = p;
                bestQ = q;
            }
        }

        System.out.println((a * bestP) + " " + (a * bestQ));
    }
}
