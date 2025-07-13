package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_24463_미로 {
    static int N, M;
    static char[][] matrix;
    static char[][] copy;
    static boolean[][] visit;
    static int[][] parentX, parentY;
    
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        matrix = new char[N][M];
        copy = new char[N][M];
        visit = new boolean[N][M];
        
        parentX = new int[N][M];
        parentY = new int[N][M];
        for(int i=0; i<N; i++){
            Arrays.fill(parentX[i], -1);
            Arrays.fill(parentY[i], -1);
        }
        
        List<int[]> holes = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            matrix[i] = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(matrix[i][j] == '.') {
                    if(i==0 || i==N-1 || j==0 || j==M-1){
                        holes.add(new int[]{i, j});
                    }
                }
            }
        }
        
        int startX = holes.get(0)[0];
        int startY = holes.get(0)[1];
        int endX   = holes.get(1)[0];
        int endY   = holes.get(1)[1];
        
        bfs(startX, startY, endX, endY);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(copy[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString().trim());
    }
    
    static void bfs(int startX, int startY, int endX, int endY) {
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(matrix[i][j] == '.') copy[i][j] = '@';
                else copy[i][j] = '+';
            }
        }
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY});
        visit[startX][startY] = true;
        
        parentX[startX][startY] = -1;
        parentY[startX][startY] = -1;
        
        boolean found = false;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            
            if(x == endX && y == endY){
                found = true;
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(!visit[nx][ny] && matrix[nx][ny] == '.') {
                    visit[nx][ny] = true;
                    parentX[nx][ny] = x;
                    parentY[nx][ny] = y;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        if(found) {
            int cx = endX;
            int cy = endY;
            
            while(cx != -1 && cy != -1) {
                copy[cx][cy] = '.';
                int px = parentX[cx][cy];
                int py = parentY[cx][cy];
                cx = px;
                cy = py;
            }
        }
    }
}