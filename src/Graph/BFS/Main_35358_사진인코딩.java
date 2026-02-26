package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_35358_사진인코딩 {
	
    static int capacity(int d, int n) {
        int maxD = 2 * n - 2;
        if (d < 0 || d > maxD) return 0;
        if (d < n) return d + 1;
        return 2 * n - 1 - d;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        int[] cnt = new int[201];
        int maxD = 0;

        for (int i = 0; i < m; i++) {
            int d = Integer.parseInt(br.readLine());
            cnt[d]++;
            if (d > maxD) maxD = d;
        }

        for (int n = 1; n <= 201; n++) {
            if (maxD > 2 * n - 2) continue;

            boolean ok = true;
            for (int d = 0; d <= 200; d++) {
                if (cnt[d] > capacity(d, n)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                System.out.println(n);
                return;
            }
        }
    }
}