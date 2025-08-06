package Graph.Dijkstra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3197_백조의호수 {
	static final int INF = 100000000;
	
	static int row, col;
	static Section[][] matrix;
	static boolean visit[][];
	static int cost[][];
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new Section[row][col];
        visit = new boolean[row][col];
        cost = new int[row][col];
        
        int x1, y1, x2, y2;
        x1 = y1 = x2 = y2 = -1;
        for(int i = 0; i < row; i++) {
        	char[] input = br.readLine().toCharArray();
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = new Section(i, j, input[j]);
        		
        		if(input[j] == 'L' && x1 == -1) {
        			x1 = i;
        			y1 = j;
        			matrix[i][j].value = '.';
        		} else if(input[j] == 'L') {
        			x2= i;
        			y2 = j;
        			matrix[i][j].value = '.';
        		}
        	}
        }
        
        timingBFS();
        int result = dijkstra(x1, y1, x2, y2);
        
        System.out.println(result);
	}
	
	private static int dijkstra(int sx, int sy, int ex, int ey) {
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

	    pq.add(new int[] {sx, sy, 0});

	    while (!pq.isEmpty()) {
	        int[] cur = pq.poll();

	        if (cur[0] == ex && cur[1] == ey) return cur[2];
	        
	        if (visit[cur[0]][cur[1]]) continue;
	        visit[cur[0]][cur[1]] = true;

	        for (int d = 0; d < 4; d++) {
	            int nx = cur[0] + dx[d];
	            int ny = cur[1] + dy[d];
	            
	            if(nx < 0 || nx >= row || ny < 0 || ny >= col || visit[nx][ny]) continue;

	            pq.add(new int[]{nx, ny, Math.max(cur[2], cost[nx][ny])});
	        }
	    }
	    
	    return -1;
	}

	
	private static void timingBFS() {
		Queue<int[]> q = new ArrayDeque<>();
		
		for (int i = 0; i < row; i++) {
	        for (int j = 0; j < col; j++) {
	            if (matrix[i][j].value != 'X') {
	                cost[i][j] = 0;
	                q.add(new int[]{i, j});
	            } else {
	                cost[i][j] = INF;
	            }
	        }
	    }

	    while (!q.isEmpty()) {
	        int[] cur = q.poll();
	        int x = cur[0], y = cur[1];

	        for (int d = 0; d < 4; d++) {
	            int nx = x + dx[d];
	            int ny = y + dy[d];
	            
	            if (nx < 0 || nx >= row || ny < 0 || ny >= col || cost[nx][ny] != INF) continue;

	            cost[nx][ny] = cost[x][y] + 1;
	            q.add(new int[]{nx, ny});
	        }
	    }
	}

	public static class Section {
		int x, y;
		char value;
		int timing;
		
		public Section(int x, int y, char value) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.timing = 0;
		}
		
		public void updateTiming() {
			this.timing++;
		}
	}

}
