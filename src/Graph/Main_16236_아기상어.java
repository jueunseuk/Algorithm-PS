package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
    static int N;
    static int[][] matrix;
    static boolean[][] visit;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Shark {
        int x;
        int y;
        int size;
        int eatCount;
        
        public Shark(int x, int y, int size, int eatCount) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eatCount = eatCount;
        }
    }

    static Shark shark;
    static int time = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
            	matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j] == 9){
                    shark = new Shark(i, j, 2, 0);
                    matrix[i][j] = 0;
                }
            }
        }

        while(true){
            Fish target = bfs(); 
            if(target == null) {
                System.out.println(time);
                break;
            } else {
                shark.x = target.x;
                shark.y = target.y;
                time += target.dist;
                matrix[target.x][target.y] = 0;

                shark.eatCount++;
                if(shark.eatCount == shark.size){
                    shark.size++;
                    shark.eatCount = 0;
                }
            }
        }
    }

    public static Fish bfs(){
    	visit = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{shark.x, shark.y, 0});
        visit[shark.x][shark.y] = true;

        List<Fish> fishes = new ArrayList<>();

        int minDist = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if(dist > minDist) break;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(!visit[nx][ny] && matrix[nx][ny] <= shark.size){
                	visit[nx][ny] = true;
                    
                    q.offer(new int[]{nx, ny, dist+1});
                    
                    if(matrix[nx][ny] != 0 && matrix[nx][ny] < shark.size){
                        fishes.add(new Fish(nx, ny, dist+1));
                        minDist = dist+1;
                    }
                }
            }
        }

        if(fishes.isEmpty()) return null;
        
        fishes.sort((o1, o2) -> {
            if(o1.dist == o2.dist){
                if(o1.x == o2.x) return Integer.compare(o1.y, o2.y);
                return Integer.compare(o1.x, o2.x);
            }
            return Integer.compare(o1.dist, o2.dist);
        });

        return fishes.get(0); 
    }

    public static class Fish {
        int x;
        int y;
        int dist;
        
        public Fish(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
