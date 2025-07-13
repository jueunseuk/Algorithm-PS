package Graph;
import java.io.*;
import java.util.*;

public class Main_25552_잔디예측하기 {
    static int N, M, D;
    static char[][] init, target;
    static boolean[][] vis;
    static int[] dr, dc;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init   = new char[N][M];
        target = new char[N][M];

        int cap = N * M;
        int[] q = new int[cap];
        int head = 0, tail = 0;

        for (int i = 0; i < N; i++) {
            init[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (init[i][j] == 'O') q[tail++] = i * M + j;
            }
        }

        D = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) target[i] = br.readLine().toCharArray();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (init[i][j] == 'O' && target[i][j] == 'X') {
                    System.out.println("NO");
                    return;
                }

        buildOffsets();
        vis = new boolean[N][M];

        while (head < tail) {
            int pos = q[head++];
            int r = pos / M, c = pos % M;
            if (vis[r][c] || target[r][c] == 'X') continue;
            vis[r][c] = true;
            for (int k = 0; k < dr.length; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (!vis[nr][nc] && target[nr][nc] == 'O')
                    q[tail++] = nr * M + nc;
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (target[i][j] == 'O' && !vis[i][j]) {
                    System.out.println("NO");
                    return;
                }

        System.out.println("YES");
    }

    static void buildOffsets() {
        int max = (2 * D + 1) * (2 * D + 1) - 1;
        dr = new int[max];
        dc = new int[max];
        int idx = 0;
        for (int r = -D; r <= D; r++) {
            int left = D - Math.abs(r);
            for (int c = -left; c <= left; c++) {
                if (r == 0 && c == 0) continue;
                dr[idx] = r;
                dc[idx] = c;
                idx++;
            }
        }
        dr = Arrays.copyOf(dr, idx);
        dc = Arrays.copyOf(dc, idx);
    }
}
