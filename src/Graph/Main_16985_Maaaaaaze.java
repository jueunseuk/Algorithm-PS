package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16985_Maaaaaaze {
    static final int N = 5;
    static int[][][] board = new int[5][N][N];
    static int[][][][] rotated = new int[5][4][N][N]; 
    static boolean[][][] visited;
    
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, 0, 1, -1};

    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            for (int row = 0; row < N; row++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int col = 0; col < N; col++) {
                    board[i][row][col] = Integer.parseInt(st.nextToken());
                }
            }
        }
        br.close();

        for (int i = 0; i < 5; i++) {
            rotated[i][0] = copy(board[i]);
            for (int r = 1; r < 4; r++) {
                rotated[i][r] = rotate(rotated[i][r - 1]);
            }
        }

        int[] perm = new int[]{0,1,2,3,4};

        permute(perm, 0);

        System.out.println(minDist == Integer.MAX_VALUE ? -1 : minDist);
    }

    static void permute(int[] arr, int depth) {
        if (depth == arr.length) {
            checkAllRotations(arr);
            return;
        }
        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permute(arr, depth + 1);
            swap(arr, depth, i);
        }
    }

    static void checkAllRotations(int[] arr) {
        for (int r0 = 0; r0 < 4; r0++) {
            for (int r1 = 0; r1 < 4; r1++) {
                for (int r2 = 0; r2 < 4; r2++) {
                    for (int r3 = 0; r3 < 4; r3++) {
                        for (int r4 = 0; r4 < 4; r4++) {
                            int[][][] maze = new int[5][N][N];
                            maze[0] = rotated[arr[0]][r0];
                            maze[1] = rotated[arr[1]][r1];
                            maze[2] = rotated[arr[2]][r2];
                            maze[3] = rotated[arr[3]][r3];
                            maze[4] = rotated[arr[4]][r4];

                            if (maze[0][0][0] == 0 || maze[4][4][4] == 0) continue;

                            int dist = bfs(maze);
                            minDist = Math.min(minDist, dist);
                        }
                    }
                }
            }
        }
    }

    static int bfs(int[][][] maze) {
        visited = new boolean[5][N][N];
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int z = curr[0], x = curr[1], y = curr[2], dist = curr[3];

            if (z == 4 && x == 4 && y == 4) {
                return dist;
            }

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= 5 || nx >= N || ny >= N) continue;
                
                if (!visited[nz][nx][ny] && maze[nz][nx][ny] == 1) {
                    visited[nz][nx][ny] = true;
                    q.offer(new int[] {nz, nx, ny, dist + 1});
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    static int[][] rotate(int[][] src) {
        int[][] ret = new int[N][N];
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                ret[r][c] = src[N - 1 - c][r];
            }
        }
        
        return ret;
    }

    static int[][] copy(int[][] src) {
        int[][] ret = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            System.arraycopy(src[i], 0, ret[i], 0, N);
        }
        
        return ret;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
