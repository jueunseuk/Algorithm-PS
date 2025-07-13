package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1520_내리막길 {
    static int row, col;
    static int[][] matrix;
    static int[][] dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        dp = new int[row][col];
        
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
            	matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(dfs(0, 0));
    }
    
    static int dfs(int x, int y) {
        if (x == row - 1 && y == col - 1) {
            return 1;
        }
        
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        
        dp[x][y] = 0;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                if (matrix[nx][ny] < matrix[x][y]) {
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }
        
        return dp[x][y];
    }
}
