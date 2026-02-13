package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_34316_사각형개수세기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] a = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
            	a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(N > M) {
            int[][] t = new int[M][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) t[j][i] = a[i][j];
            }
            a = t;
            int tmp = N; N = M; M = tmp;
        }

        long ans = 0;
        for(int r1 = 0; r1 < N - 1; r1++) {
            for(int r2 = r1 + 1; r2 < N; r2++) {
                int[] freq = new int[21];
                for(int c = 0; c < M; c++) {
                    int v = a[r1][c] + a[r2][c];
                    ans += freq[20 - v];
                    freq[v]++;
                }
            }
        }

        System.out.println(ans);
    }
}