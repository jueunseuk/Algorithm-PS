package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다 {
    static int row, col;
    static char[][] matrix;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col];
        
        int sx = 0, sy = 0;
        for (int i = 0; i < row; i++) {
            matrix[i] = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    sx = i;
                    sy = j;
                }
            }
        }
        
        System.out.println(bfs(sx, sy));
    }

    private static int bfs(int x, int y) {
        boolean[][][] visited = new boolean[row][col][64];
        Queue<State> q = new ArrayDeque<>();
        
        visited[x][y][0] = true;
        q.offer(new State(x, y, 0, 0));
        
        while (!q.isEmpty()) {
            State cur = q.poll();
            
            if (matrix[cur.x][cur.y] == '1') return cur.dist;
            
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                
                if (matrix[nx][ny] == '#') continue;
                
                int nk = cur.keys;
                
                char ch = matrix[nx][ny];
                
                if ('a' <= ch && ch <= 'f') nk |= 1 << (ch - 'a');
                
                if ('A' <= ch && ch <= 'F' && (nk & (1 << (ch - 'A'))) == 0) continue;
                
                if (!visited[nx][ny][nk]) {
                    visited[nx][ny][nk] = true;
                    q.offer(new State(nx, ny, cur.dist + 1, nk));
                }
            }
        }
        
        return -1;
    }

    static class State {
        int x, y, dist, keys;
        State(int x, int y, int dist, int keys) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.keys = keys;
        }
    }
}
