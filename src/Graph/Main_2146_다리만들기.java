package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146_다리만들기 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        visited = new boolean[N][N];
        
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int label = 2;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    labelIsland(i, j, label);
                    label++;
                }
            }
        }

        for(int islandLabel = 2; islandLabel < label; islandLabel++){
            int[][] dist = new int[N][N];
            boolean[][] visitedBfs = new boolean[N][N];
            Queue<int[]> q = new ArrayDeque<>();
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == islandLabel){
                        if(isBoundary(i, j)){
                            q.offer(new int[]{i, j});
                            visitedBfs[i][j] = true;
                        }
                    }
                }
            }

            while(!q.isEmpty()){
                int[] curr = q.poll();
                int cx = curr[0];
                int cy = curr[1];
                
                for(int d=0; d<4; d++){
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];
                    
                    if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                    
                    if(!visitedBfs[nx][ny] && map[nx][ny] != islandLabel){
                        visitedBfs[nx][ny] = true;
                        dist[nx][ny] = dist[cx][cy] + 1;
                        
                        if(map[nx][ny] != 0 && map[nx][ny] != islandLabel){
                            answer = Math.min(answer, dist[cx][cy]);
                        } else {
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
    
    static void labelIsland(int i, int j, int label){
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        map[i][j] = label;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            
            for(int d=0; d<4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(!visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    map[nx][ny] = label;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
    
    static boolean isBoundary(int x, int y){
        for(int d=0; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
            
            if(map[nx][ny] == 0){
                return true;
            }
        }
        return false;
    }
}
