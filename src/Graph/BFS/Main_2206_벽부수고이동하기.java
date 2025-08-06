package Graph.BFS;
import java.io.*;
import java.util.*;

public class Main_2206_벽부수고이동하기 {
    static int N, M;
    static int[][] map;
    static boolean[][][] v;
    
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        v = new boolean[N][M][2];
        
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs());
    }
    
    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0, 0, 0, 1});
        v[0][0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], w = cur[2], dist = cur[3];
            
            if(x == N-1 && y == M-1) {
                return dist;
            }
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                
                if(map[nx][ny] == 0){
                    if(!v[nx][ny][w]){
                        v[nx][ny][w] = true;
                        q.offer(new int[]{nx, ny, w, dist+1});
                    }
                }
                else {
                    if(w == 0 && !v[nx][ny][1]) {
                        v[nx][ny][1] = true;
                        q.offer(new int[]{nx, ny, 1, dist+1});
                    }
                }
            }
        }
        
        return -1;
    }
}
