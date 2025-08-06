package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15653_구슬탈출4 {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visit;

    // Directions: up, down, left, right
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class State {
        int rx, ry, bx, by, dist;
        
        public State(int rx, int ry, int bx, int by, int dist) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visit = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        // input
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'R'){
                    rx = i; ry = j;
                } else if(board[i][j] == 'B'){
                    bx = i; by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by){
        Queue<State> queue = new LinkedList<>();
        
        queue.offer(new State(rx, ry, bx, by, 0));
        visit[rx][ry][bx][by] = true;

        while(!queue.isEmpty()){
            State cur = queue.poll();

            for(int i = 0; i < 4; i++){
                int[] nextRed = move(cur.rx, cur.ry, i);
                int[] nextBlue = move(cur.bx, cur.by, i);

                int rnx = nextRed[0], rny = nextRed[1];
                int bnx = nextBlue[0], bny = nextBlue[1];
                boolean redHole = (board[rnx][rny] == 'O');
                boolean blueHole = (board[bnx][bny] == 'O');

                if(blueHole) continue;
                
                // result
                if(redHole && !blueHole) return cur.dist + 1;

                if(rnx == bnx && rny == bny) {
                    int redDist = Math.abs(rnx - cur.rx) + Math.abs(rny - cur.ry);
                    int blueDist = Math.abs(bnx - cur.bx) + Math.abs(bny - cur.by);
                    
                    if(redDist > blueDist){
                        rnx -= dx[i];
                        rny -= dy[i];
                    } else {
                        bnx -= dx[i];
                        bny -= dy[i];
                    }
                }

                if(!visit[rnx][rny][bnx][bny]) {
                	visit[rnx][rny][bnx][bny] = true;
                    queue.offer(new State(rnx, rny, bnx, bny, cur.dist+1));
                }
            }
        }
        
        return -1;
    }

    static int[] move(int x, int y, int d){
        while(true) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(board[nx][ny] == '#' ) {
                break;
            }
            
            x = nx; 
            y = ny;
            
            if(board[x][y] == 'O') {
                break;
            }
        }
        
        return new int[]{x, y};
    }
}
