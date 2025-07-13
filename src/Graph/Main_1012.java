package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012 {
	
	static boolean[][] field, isVisited;
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			field = new boolean[N][M];
			isVisited = new boolean[N][M]; // initialize to false
			int cnt = 0;
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				field[to][from] = true;
				
			}
				
				for(int k = 0; k < N; k++) {
					for(int j = 0; j < M; j++) {
						if(!isVisited[k][j] && field[k][j]) {
							bfs(k, j);
							cnt++;
						}
					}
				}
			
			System.out.println(cnt);
		}//outer_for
		
		
		br.close();
	}//main
	
	public static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row, col});
		
		isVisited[row][col] = true;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0];
			int y = pos[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if(field[nx][ny] && !isVisited[nx][ny]) {
						queue.add(new int[] {nx, ny});
						isVisited[nx][ny] = true;
					}
				}
			}
		}
		
	}//bfs
}//class