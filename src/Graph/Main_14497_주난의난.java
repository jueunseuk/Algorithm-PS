package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_14497_주난의난 {
	static final int INF = 1000000;
	static int row, col;
    static char[][] matrix;
    static int cost[][];
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col];
        cost = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        	Arrays.fill(cost[i], INF);
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        int x1 = Integer.parseInt(st.nextToken())-1;
        int y1 = Integer.parseInt(st.nextToken())-1;
        int x2 = Integer.parseInt(st.nextToken())-1;
        int y2 = Integer.parseInt(st.nextToken())-1;
        
        for(int i = 0; i < row; i++) {
        	matrix[i] = br.readLine().toCharArray();
        }
        
        matrix[x2][y2] = '0';
        
        bfs(x1, y1, x2, y2);
	}

	private static void bfs(int i, int j, int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, j});
		cost[i][j] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.pollFirst();
			
			if(poll[0] == x && poll[1] == y) {
				System.out.println(cost[poll[0]][poll[1]]+1);
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && nx < row && ny >= 0 && ny < col) {
					int c = matrix[nx][ny] == '0' ? 0 : 1;
					if(cost[nx][ny] > cost[poll[0]][poll[1]] + c) {
						cost[nx][ny] = cost[poll[0]][poll[1]] + c;
						
						if(c == 0) {
							q.offerFirst(new int[] {nx, ny});
						} else {
							q.offerLast(new int[] {nx, ny});
						}
					}
				}
			}
		}
	}
}