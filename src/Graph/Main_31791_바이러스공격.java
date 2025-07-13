package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_31791_바이러스공격 {
	
    static class Virus {
        int row, col, time;
        public Virus(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    
    static int R, C;
    static int Tg, Tb, X, B;
    static char[][] pnuMap;
    
    static Queue<Virus> qVirus = new LinkedList<>();
    static Queue<Virus> qBuilding = new LinkedList<>();
    
    static int[][] visited;
    static int[][] virus;
    
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    
    static Virus search() {
        if (qVirus.isEmpty()) {
            return qBuilding.poll();
        }
        if (qBuilding.isEmpty()) {
            return qVirus.poll();
        }
        int virusTime = qVirus.peek().time;
        int buildingTime = qBuilding.peek().time;
        if (virusTime < buildingTime) {
            return qVirus.poll();
        } else {
            return qBuilding.poll();
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        Tg = Integer.parseInt(st.nextToken());
        Tb = Integer.parseInt(st.nextToken());
        X  = Integer.parseInt(st.nextToken());
        B  = Integer.parseInt(st.nextToken());
        
        pnuMap = new char[R][C];
        visited = new int[R][C];
        virus = new int[R][C];
        
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                pnuMap[r][c] = line.charAt(c);
                if (pnuMap[r][c] == '*') {
                	Virus firstVal = new Virus(r, c, 0);
                    qVirus.offer(firstVal);
                    visited[r][c] = 1;
                }
            }
        }
        
        while (!qVirus.isEmpty() || !qBuilding.isEmpty()) {
        	Virus current = search();
            int curRow = current.row;
            int curCol = current.col;
            int curTime = current.time;
            
            if (curTime > Tg) break;
            
            virus[curRow][curCol] = 1;
            
            for (int i = 0; i < 4; i++) {
                int nextR = curRow + dr[i];
                int nextC = curCol + dc[i];
                if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) continue;
                if (visited[nextR][nextC] == 1) continue;
                visited[nextR][nextC] = 1;
                
                if (pnuMap[nextR][nextC] == '#') {
                	Virus nextVal = new Virus(nextR, nextC, curTime + Tb + 1);
                    qBuilding.offer(nextVal);
                } else if (pnuMap[nextR][nextC] == '.') {
                	Virus nextVal = new Virus(nextR, nextC, curTime + 1);
                    qVirus.offer(nextVal);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        boolean safeFound = false;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (virus[r][c] == 0) {
                    safeFound = true;
                    sb.append((r + 1) + " " + (c + 1) + "\n");
                }
            }
        }
        if (!safeFound) {
            System.out.println(-1);
        } else {
            System.out.print(sb.toString());
        }
    }
}
