package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3184_양 {
	static int row, col;
	static char matrix[][];
	static boolean visit[][];
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col];
        visit = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
        	matrix[i] = br.readLine().toCharArray();
        }
        
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(!visit[i][j] && matrix[i][j] != '#') {
        			bfs(i, j);
        		}
        	}
        }
        
        int o = 0, v = 0;
        
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(matrix[i][j] == 'o') {
        			o++;
        		} else if(matrix[i][j] == 'v') {
        			v++;
        		}
        	}
        }

        System.out.println(o+" "+v);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		Queue<int[]> o = new ArrayDeque<>();
		Queue<int[]> v = new ArrayDeque<>();
		
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		
		if(matrix[i][j] == 'v') {
			v.offer(new int[] {i, j});
		} else if(matrix[i][j] == 'o') {
			o.offer(new int[] {i, j});
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] != '#') {
					visit[nx][ny] = true;
					if(matrix[nx][ny] == 'o') {
						o.offer(new int[] {nx, ny});
					} else if(matrix[nx][ny] == 'v') {
						v.offer(new int[] {nx, ny});
					}
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
		if(o.size() > v.size()) {
			for(int[] out : v) {
				matrix[out[0]][out[1]] = '.';
			}
		} else {
			for(int[] out : o) {
				matrix[out[0]][out[1]] = '.';
			}
		}
	}
}