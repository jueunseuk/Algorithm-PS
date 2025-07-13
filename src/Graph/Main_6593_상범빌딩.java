package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6593_상범빌딩 {
	static char matrix[][][];
	static boolean visit[][][];
	static int row, col, depth, endX, endY, endZ;
	
	static int dz[] = {1, -1, 0, 0, 0, 0};
	static int dx[] = {0, 0, 1, -1, 0, 0};
	static int dy[] = {0, 0, 0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			
			depth = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			
			if(depth == 0 && row == 0 && col == 0) {
				break;
			}
			
			matrix = new char[depth][row][col];
			visit = new boolean[depth][row][col];
			
			int startX = 0, startY = 0, startZ = 0;
			
			for(int i = 0; i < depth; i++) {
				for(int j = 0; j < row; j++) {
					matrix[i][j] = br.readLine().toCharArray();
					for(int k = 0; k < col; k++) {
						if(matrix[i][j][k] == 'S') {
							startZ = i;
							startX = j;
							startY = k;
						} else if(matrix[i][j][k] == 'E') {
							endZ = i;
							endX = j;
							endY = k;
						}
					}
				}
				br.readLine();
			}
			
			int result = bfs(startX, startY, startZ);
			
			if(result > 0) {
				sb.append("Escaped in ").append(result).append(" minute(s).").append("\n");
			} else {
				sb.append("Trapped!").append("\n");
			}
			
		}
		
		System.out.println(sb.toString().trim());
		
	}

	private static int bfs(int x, int y, int z) {
		Queue<int[]> q = new ArrayDeque<>();
		
		visit[z][x][y] = true;
		q.add(new int[] {z, x, y, 0});
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int pollZ = poll[0];
			int pollX = poll[1];
			int pollY = poll[2];
			
			for(int i = 0; i < 6; i++) {
				int nz = pollZ + dz[i];
				int nx = pollX + dx[i];
				int ny = pollY + dy[i];
				
				if(nx >= 0 && ny >= 0 && nz >= 0 && nx < row && ny < col && nz < depth && !visit[nz][nx][ny] && matrix[nz][nx][ny] != '#') {
					if(nx == endX && ny == endY && nz == endZ) {
						return poll[3]+1;
					}
					visit[nz][nx][ny] = true;
					q.add(new int[] {nz, nx, ny, poll[3]+1});
				}
			}
		}
		
		return 0;
	}

}
