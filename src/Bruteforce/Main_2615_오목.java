package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2615_오목 {
    static final int size = 19;
    static int[][] matrix = new int[size][size];

    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                int color = matrix[x][y];
                if (color == 0) continue;

                for(int d = 0; d < 4; d++) {
                    int px = x - dx[d], py = y - dy[d];
                    if (in(px, py) && matrix[px][py] == color) continue;

                    int cnt = 0;
                    int nx = x, ny = y;
                    while(in(nx, ny) && matrix[nx][ny] == color) {
                        cnt++;
                        nx += dx[d];
                        ny += dy[d];
                    }
                    
                    if(cnt == 5) {
                        System.out.println(color);
                        System.out.println((x + 1) + " " + (y + 1));
                        return;
                    }
                }
            }
        }
        
        System.out.println(0);
    }

    static boolean in(int x, int y) {
        return 0 <= x && x < size && 0 <= y && y < size;
    }
}