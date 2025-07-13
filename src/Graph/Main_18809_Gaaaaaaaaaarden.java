package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18809_Gaaaaaaaaaarden {
    static int N, M, G, R;
    static int[][] garden;
    static List<Pos> fertile;
    static int fertileCount;
    static int maxFlower = 0;
    
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        garden = new int[N][M];
        fertile = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                garden[i][j] = Integer.parseInt(st.nextToken());
                
                if (garden[i][j] == 2) {
                    fertile.add(new Pos(i, j));
                }
            }
        }
        
        fertileCount = fertile.size();
        
        comb(0, 0, new int[G + R]);
        
        System.out.println(maxFlower);
    }

    private static void comb(int start, int depth, int[] select) {
        if (depth == (G + R)) {
            distribute(0, 0, select, new boolean[G + R]);
            return;
        }
        
        for (int i = start; i < fertileCount; i++) {
            select[depth] = i;
            comb(i + 1, depth + 1, select);
        }
    }

    private static void distribute(int idx, int greenUsed, int[] select, boolean[] checked) {
        if (greenUsed == G) {
            bfs(select, checked);
            return;
        }
        
        if (idx >= (G + R)) {
            return;
        }
        
        checked[idx] = true;
        distribute(idx + 1, greenUsed + 1, select, checked);
        checked[idx] = false;
        distribute(idx + 1, greenUsed, select, checked);
    }

    private static void bfs(int[] select, boolean[] checked) {
        int[][] greenTime = new int[N][M];
        int[][] redTime = new int[N][M];
        boolean[][] flower = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                greenTime[i][j] = -1;
                redTime[i][j] = -1;
            }
        }
        
        Queue<Info> q = new LinkedList<>();
        for (int i = 0; i < (G + R); i++) {
            Pos p = fertile.get(select[i]);
            
            if (checked[i]) {
                greenTime[p.x][p.y] = 0;
                q.offer(new Info(p.x, p.y, 0, 'G'));
            } else {
                redTime[p.x][p.y] = 0;
                q.offer(new Info(p.x, p.y, 0, 'R'));
            }
        }
        
        int flowerCount = 0;
        while (!q.isEmpty()) {
            Info cur = q.poll();
            
            if (flower[cur.x][cur.y]) continue;
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                
                if (garden[nx][ny] == 0) continue;
                
                if (cur.color == 'G') {
                    if (greenTime[nx][ny] == -1) {
                        if (redTime[nx][ny] == cur.time + 1) {
                        	flower[nx][ny] = true;
                            flowerCount++;
                            greenTime[nx][ny] = cur.time + 1;
                        } else if (redTime[nx][ny] == -1) {
                            greenTime[nx][ny] = cur.time + 1;
                            q.offer(new Info(nx, ny, cur.time + 1, 'G'));
                        }
                    }
                } else {
                    if (redTime[nx][ny] == -1) {
                        if (greenTime[nx][ny] == cur.time + 1) {
                        	flower[nx][ny] = true;
                            flowerCount++;
                            redTime[nx][ny] = cur.time + 1;
                        } else if (greenTime[nx][ny] == -1) {
                            redTime[nx][ny] = cur.time + 1;
                            q.offer(new Info(nx, ny, cur.time + 1, 'R'));
                        }
                    }
                }
            }
        }
        
        maxFlower = Math.max(maxFlower, flowerCount);
    }

    static class Info {
        int x, y, time;
        char color;
        
        Info(int x, int y, int time, char color) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.color = color;
        }
    }

    static class Pos {
        int x, y;
        
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
