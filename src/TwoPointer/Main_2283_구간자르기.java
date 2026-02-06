package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2283_구간자르기 {
    static final int MAX = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[] diff = new long[MAX + 2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            diff[l] += 1;
            diff[r] -= 1;
        }

        for (int i = 0; i <= MAX; i++) {
            diff[i + 1] += diff[i];
        }

        long[] sum = new long[MAX + 2];
        for (int i = 0; i <= MAX; i++) {
        	sum[i + 1] = sum[i] + diff[i];
        }

        int left = 0, right = 1;
        while (left <= MAX + 1 && right <= MAX + 1) {
            long curr = sum[right] - sum[left];

            if (curr == k) {
                System.out.println(left + " " + right);
                return;
            }

            if (curr < k) right++;
            else {
                left++;
                if (left == right) right++;
            }
        }

        System.out.println("0 0");
    }
}