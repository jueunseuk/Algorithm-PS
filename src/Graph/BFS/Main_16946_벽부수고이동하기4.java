package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16946_벽부수고이동하기4 {
    static int N, M;
    static char[][] map;
    
    static int[][] compID;
    static int[] compSize;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }
        
        compID = new int[N][M];
        visited = new boolean[N][M];
        
        int id = 1;
        List<Integer> sizes = new ArrayList<>();
        sizes.add(0);
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && map[i][j] == '0') {
                    int size = bfs(i, j, id);
                    sizes.add(size);
                    id++;
                }
            }
        }
        
        compSize = new int[sizes.size()];
        for(int i=0; i<sizes.size(); i++){
            compSize[i] = sizes.get(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == '1') {
                	int sum = 1;
                    Set<Integer> nearComp = new HashSet<>();
                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        
                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if(map[nx][ny] == '0') {
                            int cId = compID[nx][ny];
                            nearComp.add(cId);
                        }
                    }
                    
                    for(int cId : nearComp){
                        sum += compSize[cId];
                    }
                    
                    sb.append(sum % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
    static int bfs(int sx, int sy, int id){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        
        visited[sx][sy] = true;
        compID[sx][sy] = id;
        
        int cnt = 1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(!visited[nx][ny] && map[nx][ny] == '0') {
                    visited[nx][ny] = true;
                    compID[nx][ny] = id;
                    queue.offer(new int[]{nx, ny});
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}
