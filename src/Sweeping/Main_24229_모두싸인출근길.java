package Sweeping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_24229_모두싸인출근길 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] data = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int[][] bridge = new int[n][2];
        int mSeg = 0;

        int s = data[0][0];
        int e = data[0][1];

        for (int i = 1; i < n; i++) {
            int L = data[i][0];
            int R = data[i][1];

            if (e >= L) {
                e = Math.max(e, R);
            } else {
                bridge[mSeg][0] = s;
                bridge[mSeg][1] = e;
                mSeg++;
                s = L;
                e = R;
            }
        }
        bridge[mSeg][0] = s;
        bridge[mSeg][1] = e;
        mSeg++;

        boolean[] visited = new boolean[mSeg];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(0);

        int ans = 0;

        while (!q.isEmpty()) {
            int me = q.pollFirst();
            int nowL = bridge[me][0];
            int nowR = bridge[me][1];

            if (visited[me]) continue;
            visited[me] = true;

            int jump = nowR - nowL;
            if (nowR > ans) ans = nowR;

            for (int i = me + 1; i < mSeg; i++) {
                int nextL = bridge[i][0];
                if (nextL <= nowR + jump) {
                    q.addLast(i);
                } else {
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}