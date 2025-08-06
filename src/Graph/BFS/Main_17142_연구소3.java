package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소3 {
    static int N, M;
    static int[][] lab;
    static List<Point> virusCandidates = new ArrayList<>();

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                lab[r][c] = Integer.parseInt(st.nextToken());
                if (lab[r][c] == 2) {
                    virusCandidates.add(new Point(r, c));
                }
            }
        }

        int answer = combinationAndSearch(0, 0, new ArrayList<>(), Integer.MAX_VALUE);

        System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
    }

    static int combinationAndSearch(int startIdx, int count, List<Point> chosen, int bestTime) {
        if (count == M) {
            int time = spreadVirus(chosen);
            if (time != -1 && time < bestTime) {
                bestTime = time;
            }
            return bestTime;
        }

        if (startIdx >= virusCandidates.size()) {
            return bestTime;
        }

        chosen.add(virusCandidates.get(startIdx));
        bestTime = combinationAndSearch(startIdx + 1, count + 1, chosen, bestTime);
        chosen.remove(chosen.size() - 1);

        bestTime = combinationAndSearch(startIdx + 1, count, chosen, bestTime);

        return bestTime;
    }

    static int spreadVirus(List<Point> activeViruses) {
        int[][] visitedTime = new int[N][N];
        
        for(int[] row : visitedTime) {
            Arrays.fill(row, -1);
        }

        Queue<Point> q = new LinkedList<>();
        for(Point v : activeViruses) {
            q.offer(v);
            visitedTime[v.r][v.c] = 0;
        }

        while(!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int t = visitedTime[r][c];

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(lab[nr][nc] == 1) continue;

                if(visitedTime[nr][nc] == -1) {
                    visitedTime[nr][nc] = t + 1;
                    q.offer(new Point(nr, nc));
                }
            }
        }

        int maxTime = 0;
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(lab[r][c] == 0) {
                    if(visitedTime[r][c] == -1) {
                        return -1;
                    }
                    
                    maxTime = Math.max(maxTime, visitedTime[r][c]);
                }
            }
        }

        return maxTime;
    }
}
