package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {
	static int matrix[][][];
	static boolean visit[][][];
	static int row, col, maxCnt = 0;
	static Queue<int[]> q = new ArrayDeque<>();
	
	
	static int dx[] = {0, 0, 1, -1, 0, 0};
	static int dy[] = {0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());

		matrix = new int[high][row][col];
		visit = new boolean[high][row][col];
		
		// 1 : 익음, 0 : 안 익음, -1 : 비어있음
		for(int i = 0; i < high; i++) {
			for(int j = 0; j < row; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k = 0; k < col; k++) {
					matrix[i][j][k] = Integer.parseInt(st.nextToken());
					if(matrix[i][j][k] == 1) {
						q.add(new int[] {i, j, k});
						visit[i][j][k] = true;
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
            int z = current[0];
            int x = current[1];
            int y = current[2];
            
            for(int delta = 0; delta < 6; delta++) {
            	int nz = z + dz[delta];
            	int nx = x + dx[delta];
            	int ny = y + dy[delta];
            	
            	if(nx >= 0 && ny >= 0 && nz >= 0 && nx < row && ny < col && nz < high && !visit[nz][nx][ny] && matrix[nz][nx][ny] == 0) {
            		matrix[nz][nx][ny] = matrix[z][x][y] + 1;
            		visit[nz][nx][ny] = true;
            		q.add(new int[] {nz, nx, ny});
            	}
            }
		}
		
		for (int i = 0; i < high; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (matrix[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    maxCnt = Math.max(maxCnt, matrix[i][j][k]);
                }
            }
        }
		
		System.out.println(maxCnt-1);

	}
}
