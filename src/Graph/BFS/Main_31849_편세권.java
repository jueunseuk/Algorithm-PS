package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_31849_편세권 {
    static int row, col;
    static int[][] matrix; 
    static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
    
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int room = Integer.parseInt(st.nextToken());
        int conv = Integer.parseInt(st.nextToken());

        matrix = new int[row][col];
        for(int i = 0; i < room; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            matrix[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < conv; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            matrix[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = -1;
        }

        int[][] dist = new int[row][col];
        for(int i = 0; i < row; i++){
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == -1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            
            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx < 0 || ny < 0 || nx >= row || ny >= col) {
                    continue;
                }
                
                if(dist[nx][ny] != -1) {
                    continue;
                }
                
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] > 0 && dist[i][j] != -1){ 
                    minVal = Math.min(minVal, dist[i][j] * matrix[i][j]);
                }
            }
        }

        System.out.println(minVal);
    }
}
