package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1584_게임 {
	static int size = 500, idx = 1;
	static int[][] matrix = new int[size+1][size+1];
	static boolean[][] visit = new boolean[size+1][size+1];
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	for(int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
        		for(int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
        			matrix[x][y] = 1;
        		}
        	}
        }
        
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	for(int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
        		for(int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
        			matrix[x][y] = 2;
        		}
        	}
        }
        
        bfs(0, 0);
	}

	private static void bfs(int i, int j) {
		Deque<int[]> deq = new ArrayDeque<>();
		
		deq.offer(new int[] {i, j, 0});
		visit[i][j] = true;
		
		while(!deq.isEmpty()) {
			int[] poll = deq.poll();
			
			if(poll[0] == size && poll[1] == size) {
				System.out.println(poll[2]);
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx <= size && ny <= size && !visit[nx][ny] && matrix[nx][ny] != 2) {
					if(matrix[nx][ny] == 0) {
						deq.offerFirst(new int[] {nx, ny, poll[2]});
						visit[nx][ny] = true;
					} else {
						deq.offerLast(new int[] {nx, ny, poll[2]+1});
						visit[nx][ny] = true;
					}
					visit[i][j] = true;
				}
			}
		}
		
		System.out.println(-1);
	}
}