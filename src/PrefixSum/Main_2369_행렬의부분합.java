package PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Main_2369_행렬의부분합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int mod = Integer.parseInt(st.nextToken());

        long[][] pref = new long[row + 1][col];
        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                long v = Long.parseLong(st.nextToken());
                pref[i][j] = pref[i - 1][j] + v;
            }
        }

        long cnt = 0L;
        Map<Integer, Long> freq = new HashMap<>();

        for (int i = 0; i < row; i++) {
            for (int j = i; j < row; j++) {
                freq.clear();
                freq.put(0, 1L);
                long prefix = 0L;
                for (int k = 0; k < col; k++) {
                    long add = pref[j + 1][k] - pref[i][k];
                    prefix += add;
                    int r = (int)(prefix % mod);
                    if (r < 0) r += mod;
                    long f = freq.getOrDefault(r, 0L);
                    cnt += f;
                    freq.put(r, f + 1);
                }
            }
        }

        System.out.println(cnt);
    }
}
