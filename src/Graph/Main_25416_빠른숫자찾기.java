package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_25416_빠른숫자찾기 {
	static int matrix[][] = new int[5][5];
	static boolean visit[][] = new boolean[5][5];
	static int size = 5;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		bfs(x, y);
		
		System.out.println(-1);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {x, y, 0});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int poll[] = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < size && ny < size && !visit[nx][ny] && matrix[nx][ny] != -1) {
					if(matrix[nx][ny] == 1) {
						System.out.println(poll[2]+1);
						System.exit(0);;
					}
					q.add(new int[] {nx, ny, poll[2]+1});
					visit[nx][ny] = true;
				}
			}
		}
	}

}
