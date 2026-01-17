package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14680_효빈이의과외 {
    static final int MOD = 1000000007;

    static class Mat {
        int r, c;
        int[][] a;
        Mat(int r, int c, int[][] a) { this.r = r; this.c = c; this.a = a; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Mat[] mats = new Mat[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] a = new int[r][c];
            for (int x = 0; x < r; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < c; y++) {
                    a[x][y] = Integer.parseInt(st.nextToken());
                }
            }
            mats[i] = new Mat(r, c, a);
        }

        for (int i = 0; i < n - 1; i++) {
            if (mats[i].c != mats[i + 1].r) {
                System.out.println(-1);
                return;
            }
        }

        int[] v = new int[mats[n - 1].c];
        Arrays.fill(v, 1);

        for (int i = n - 1; i >= 0; i--) {
            Mat m = mats[i];
            int[] nv = new int[m.r];

            for (int r = 0; r < m.r; r++) {
                long acc = 0;
                for (int c = 0; c < m.c; c++) {
                    acc += (long) m.a[r][c] * v[c];
                    acc %= MOD;
                }
                nv[r] = (int) acc;
            }
            v = nv;
        }

        long sum = 0;
        for (int x : v) {
            sum += x;
            sum %= MOD;
        }
        
        System.out.println(sum);
    }
}
