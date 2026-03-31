package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_35456_선형연립부등식 {

    static long floorDiv(long a, long b) {
        long q = a / b;
        long r = a % b;
        if (r != 0 && ((a ^ b) < 0)) q--;
        return q;
    }

    static long ceilDiv(long a, long b) {
        return -floorDiv(-a, b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long left = Long.MIN_VALUE / 4;
        long right = Long.MAX_VALUE / 4;

        boolean hasLower = false;
        boolean hasUpper = false;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            long num = C - B;

            if (A > 0) {
                long upper = floorDiv(num, A);
                right = Math.min(right, upper);
                hasUpper = true;
            } else {
                long lower = ceilDiv(num, A);
                left = Math.max(left, lower);
                hasLower = true;
            }
        }

        if (!hasLower || !hasUpper) {
            System.out.println(-1);
            return;
        }

        if (left > right) {
            System.out.println(0);
            return;
        }

        System.out.println(right - left + 1);
    }
}