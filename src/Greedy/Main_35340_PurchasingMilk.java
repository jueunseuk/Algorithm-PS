package Greedy;

import java.io.*;
import java.util.*;

public class Main_35340_PurchasingMilk {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        long[] a = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Long.parseLong(st.nextToken());

        long[] cost = new long[N];
        cost[0] = a[0];
        for (int i = 1; i < N; i++) {
            cost[i] = Math.min(a[i], cost[i - 1] * 2L);
        }

        int maxI = Math.min(N - 1, 60);

        StringBuilder sb = new StringBuilder();
        for (int qi = 0; qi < Q; qi++) {
            long x = Long.parseLong(br.readLine());

            long need = x;
            long cur = 0;
            long ans = Long.MAX_VALUE / 4;

            for (int i = maxI; i >= 0; i--) {
                long size = 1L << i;

                if (i >= N) continue;

                long k = need / size;
                if (k > 0) {
                    cur += k * cost[i];
                    need -= k * size;
                }

                if (need > 0) {
                    ans = Math.min(ans, cur + cost[i]);
                } else {
                    ans = Math.min(ans, cur);
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}