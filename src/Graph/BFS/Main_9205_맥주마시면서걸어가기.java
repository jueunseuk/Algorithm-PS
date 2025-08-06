package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {
    static int T, N;
    static int[][] points;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            points = new int[N+2][2];
            visited = new boolean[N+2];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[0][0] = Integer.parseInt(st.nextToken());
            points[0][1] = Integer.parseInt(st.nextToken());
            
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            points[N+1][0] = Integer.parseInt(st.nextToken());
            points[N+1][1] = Integer.parseInt(st.nextToken());
            
            boolean canReach = bfs(0);
            
            if(canReach) sb.append("happy\n");
            else sb.append("sad\n");
        }
        
        System.out.println(sb.toString().trim());
    }
    
    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            if(current == N+1) {
                return true;
            }
            
            for(int next = 0; next < N+2; next++) {
                if(visited[next]) continue;
                
                if(getDistance(current, next) <= 1000) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        
        return false;
    }
    
    static int getDistance(int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) 
             + Math.abs(points[i][1] - points[j][1]);
    }
}
