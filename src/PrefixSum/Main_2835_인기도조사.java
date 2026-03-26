package PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2835_인기도조사 {
    static final int SEC = 86400;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] diff = new long[SEC + 1];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String[] a = st.nextToken().split(":");
            st.nextToken();
            String[] b = st.nextToken().split(":");

            int s = makeToSecond(a);
            int e = makeToSecond(b);

            if (s <= e) {
                diff[s]++;
                diff[e + 1]--;
            } else {
                diff[s]++;
                diff[SEC]--;

                diff[0]++;
                diff[e + 1]--;
            }
        }

        for (int i = 1; i < SEC; i++) {
            diff[i] += diff[i - 1];
        }

        for (int i = 1; i < SEC; i++) {
            diff[i] += diff[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String[] a = st.nextToken().split(":");
            st.nextToken();
            String[] b = st.nextToken().split(":");

            int s = makeToSecond(a);
            int e = makeToSecond(b);

            long sum;
            int len;

            if (s <= e) {
                sum = rangeSum(diff, s, e);
                len = e - s + 1;
            } else {
                sum = rangeSum(diff, s, SEC - 1) + rangeSum(diff, 0, e);
                len = (SEC - s) + (e + 1);
            }

            sb.append(sum / (double) len).append("\n");
        }

        System.out.print(sb.toString().trim());
    }

    private static long rangeSum(long[] prefix, int l, int r) {
        if (l == 0) return prefix[r];
        return prefix[r] - prefix[l - 1];
    }

    private static int makeToSecond(String[] time) {
        return Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60 + Integer.parseInt(time[2]);
    }
}