package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5980_CornMaze {
	static int row, col;
	static char matrix[][];
	static boolean visit[][];
	
	static int portal[][] = new int[26][4];
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col];
        visit = new boolean[row][col];
        
        int startX = 0, startY = 0;
        for(int i = 0; i < row; i++) {
        	matrix[i] = br.readLine().toCharArray();
        	
        	for(int j = 0; j < col; j++) {
        		if(matrix[i][j] == '@') {
        			matrix[i][j] = '.';
        			startX = i;
        			startY = j;
        		} else if(matrix[i][j] >= 'A' && matrix[i][j] <= 'Z') {
        			if(portal[matrix[i][j] - 'A'][0] == 0) {
        				portal[matrix[i][j] - 'A'][0] = i;
        				portal[matrix[i][j] - 'A'][1] = j;
        			} else {
        				portal[matrix[i][j] - 'A'][2] = i;
        				portal[matrix[i][j] - 'A'][3] = j;
        			}
        		}
        	}
        }
        
        bfs(startX, startY);
	}

	public static void bfs(int startX, int startY) {
		Queue<int[]> q = new ArrayDeque<>();
		
		visit[startX][startY] = true;
		q.offer(new int[] {startX, startY, 0});
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(matrix[poll[0]][poll[1]] == '=') {
					System.out.println(poll[2]);
					return;
				}
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] != '#') {
					if(matrix[nx][ny] == '.' || matrix[nx][ny] == '=') {
						visit[nx][ny] = true;
						q.offer(new int[] {nx, ny, poll[2]+1});
					} else {
						if(nx == portal[matrix[nx][ny] - 'A'][0] && ny == portal[matrix[nx][ny] - 'A'][1]) {
							q.offer(new int[] {portal[matrix[nx][ny] - 'A'][2], portal[matrix[nx][ny] - 'A'][3], poll[2]+1});
						} else {
							q.offer(new int[] {portal[matrix[nx][ny] - 'A'][0], portal[matrix[nx][ny] - 'A'][1], poll[2]+1});
						}
					}
				}
			}
		}
	}

}