package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_11310_내륙 {
	static final int INF = Integer.MAX_VALUE;
	
	static int row, col;
	static char curr;
	static char[][] matrix;
	static int[][] cost;
	static int[] result = new int[26];
	
	static final int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static final int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col];
        for(int i = 0; i < row; i++) {
        	matrix[i] = br.readLine().toCharArray();
        }
        
        zoBfs();
        
        Arrays.fill(result, INF);
        
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		char c = matrix[i][j];
                if (c == 'W') continue;
                result[c - 'A'] = Math.min(result[c - 'A'], cost[i][j]);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
        	if(result[i] != INF) {
        		sb.append((char) ('A'+i)).append(" ").append(result[i]).append("\n");
        	}
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void zoBfs() {
		Deque<Section> deq = new ArrayDeque<>();
		cost = new int[row][col];
		
		for (int i = 0; i < row; i++) {
	        Arrays.fill(cost[i], INF);
	    }
		
		for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 'W') {
                    cost[i][j] = 0;
                    deq.offerFirst(new Section(i, j));
                }
            }
        }
		
		while (!deq.isEmpty()) {
            Section cur = deq.pollFirst();
            int x = cur.x;
            int y = cur.y;

            for (int dir = 0; dir < 8; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;

                int w = getCost(matrix[x][y], matrix[nx][ny]);

                if (cost[nx][ny] > cost[x][y] + w) {
                	cost[nx][ny] = cost[x][y] + w;

                    if (w == 0) {
                        deq.offerFirst(new Section(nx, ny));
                    } else {
                        deq.offerLast(new Section(nx, ny));
                    }
                }
            }
        }
	}
	
	private static int getCost(char from, char to) {
        if (from == 'W' || to == 'W') return 0;
        if (from == to) return 0;
        return 1;
    }
	
	static class Section {
		int x, y;
		
		public Section(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}