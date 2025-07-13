package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18405_경쟁적전염 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] lab = new int[N][N];
        
        List<Virus> viruses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] != 0) {
                    viruses.add(new Virus(lab[i][j], i, j, 0));
                }
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        
        Collections.sort(viruses);
        
        Queue<Virus> queue = new LinkedList<>();
        
        for (Virus v : viruses) {
            queue.offer(v);
        }
        
        while (!queue.isEmpty()) {
            Virus virus = queue.poll();
            
            if (virus.time == S) {
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (lab[nx][ny] == 0) {
                        lab[nx][ny] = virus.type; 
                        queue.offer(new Virus(virus.type, nx, ny, virus.time + 1));
                    }
                }
            }
        }
        
        System.out.println(lab[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1]);
    }
    
    static class Virus implements Comparable<Virus> {
        int type;
        int x;
        int y;
        int time;

        public Virus(int type, int x, int y, int time) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.time = time;
        }
        
        @Override
        public int compareTo(Virus o) {
            return this.type - o.type;
        }
    }
}
