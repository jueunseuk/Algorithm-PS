package Graph.BFS;
import java.io.*;
import java.util.*;

public class Main_17086_아기상어2 {
    static int row, col;
    static int[][] matrix;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        matrix = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col && matrix[nx][ny] == 0) {
                    matrix[nx][ny] = matrix[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int maxDistance = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxDistance = Math.max(maxDistance, matrix[i][j]);
            }
        }

        System.out.println(maxDistance - 1);
    }
}
