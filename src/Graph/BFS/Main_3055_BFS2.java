package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_BFS2 {
    static int row, col;
    static char[][] board;
    static boolean[][] visited;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]> waterQueue = new ArrayDeque<>();
    static Queue<int[]> hedgehogQueue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new char[row][col];
        visited = new boolean[row][col];
        int[] posD = new int[2];

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'S') {
                    hedgehogQueue.add(new int[]{i, j, 0}); // 고슴도치의 초기 위치와 초기 거리를 큐에 추가
                    visited[i][j] = true;
                } else if (board[i][j] == 'D') {
                    posD[0] = i;
                    posD[1] = j;
                } else if (board[i][j] == '*') {
                    waterQueue.add(new int[]{i, j}); // 물의 위치를 큐에 추가
                }
            }
        }

        int result = bfs(posD);
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    private static int bfs(int[] posD) {
        while (!hedgehogQueue.isEmpty()) {
            // 물 먼저 이동
            int waterSize = waterQueue.size();
            for (int i = 0; i < waterSize; i++) {
                int[] water = waterQueue.poll();
                int currentRow = water[0];
                int currentCol = water[1];

                for (int[] dir : direction) {
                    int newRow = currentRow + dir[0];
                    int newCol = currentCol + dir[1];

                    if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) {
                        if (board[newRow][newCol] == '.') {
                            board[newRow][newCol] = '*';
                            waterQueue.add(new int[]{newRow, newCol});
                        }
                    }
                }
            }

            // 고슴도치 이동
            int hedgehogSize = hedgehogQueue.size();
            for (int i = 0; i < hedgehogSize; i++) {
                int[] hedgehog = hedgehogQueue.poll();
                int currentRow = hedgehog[0];
                int currentCol = hedgehog[1];
                int currentDist = hedgehog[2];

                for (int[] dir : direction) {
                    int newRow = currentRow + dir[0];
                    int newCol = currentCol + dir[1];

                    if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) {
                        if (newRow == posD[0] && newCol == posD[1]) {
                            return currentDist + 1;
                        }
                        if (!visited[newRow][newCol] && board[newRow][newCol] == '.') {
                            visited[newRow][newCol] = true;
                            hedgehogQueue.add(new int[]{newRow, newCol, currentDist + 1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
