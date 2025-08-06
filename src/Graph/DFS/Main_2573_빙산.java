package Graph.DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int row, col, k;
    static int[][] matrix;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        
        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int days = 0;
        
        while(true) {
            if(!scan()) {
                visit = new boolean[row][col];
                
                int chunk = 0;
                
                for(int i = 0; i < row; i++) {
                    for(int j = 0; j < col; j++) {
                        if(matrix[i][j] != 0 && !visit[i][j]) {
                            chunk++;
                            if(chunk >= 2) break;
                            dfs(i, j);
                        }
                    }
                    if(chunk >= 2) break;
                }
                
                if(chunk >= 2) {
                    System.out.println(days);
                } else {
                    System.out.println(0);
                }
                
                return;
            }
            meltAll();
            days++;
        }
    }

    public static boolean scan() {
        visit = new boolean[row][col];
        
        boolean is = false;
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] != 0 && !visit[i][j]) {
                    if(!is) {
                        is = true;
                        dfs(i, j);
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return is;
    }

    public static void dfs(int i, int j) {
        visit[i][j] = true;
        for(int delta = 0; delta < 4; delta++) {
            int nx = i + dx[delta];
            int ny = j + dy[delta];
            if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] != 0) {
                dfs(nx, ny);
            }
        }
    }

    public static int checker(int i, int j) {
        int cnt = 0;
        for(int delta = 0; delta < 4; delta++) {
            int nx = i + dx[delta];
            int ny = j + dy[delta];
            if(nx >= 0 && ny >= 0 && nx < row && ny < col && matrix[nx][ny] == 0) {
                cnt++;
            }
        }
        
        return cnt;
    }

    public static void meltAll() {
        int[][] melt = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] > 0) {
                    melt[i][j] = checker(i, j);
                }
            }
        }
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] > 0) {
                    matrix[i][j] -= melt[i][j];
                    if(matrix[i][j] < 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
