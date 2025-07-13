package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17244_아맞다우산 {
	static int row, col;
	static char[][] matrix;
	static boolean[][][] visit;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        
        int sx = 0, sy = 0;
        char idx = '1';
        int cnt = 0;
        matrix = new char[row][col];
        for(int i = 0; i < row; i++) {
        	matrix[i] = br.readLine().toCharArray();
        	for(int j = 0; j < col; j++) {
        		if(matrix[i][j] == 'S') {
        			sx = i;
        			sy = j;
        			matrix[i][j] = '.';
        		} else if(matrix[i][j] == 'X') {
        			matrix[i][j] = idx++;
        			cnt++;
        		}
        	}
        }
        
        bfs(sx, sy, cnt);
	}

	private static void bfs(int sx, int sy, int cnt) {
		Queue<Section> q = new ArrayDeque<>();
		visit = new boolean[row][col][1<<cnt];
		
		q.offer(new Section(sx, sy, 0, 0));
		visit[sx][sy][0] = true;
		
		int complete = (1 << cnt) - 1;
		while(!q.isEmpty()) {
			Section poll = q.poll();
			
			if(matrix[poll.x][poll.y] == 'E' && poll.k == complete) {
				System.out.println(poll.dist);
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll.x + dx[delta];
				int ny = poll.y + dy[delta];
				int nk = poll.k;
				
				if(outOfRange(nx, ny) || matrix[nx][ny] == '#') continue;
				
				if(matrix[nx][ny] >= '1' && matrix[nx][ny] <= '5') {
					int bit = matrix[nx][ny] - '1';
					nk |= (1 << bit);
				}
				
				if(visit[nx][ny][nk]) continue;
				
				visit[nx][ny][nk] = true;
				q.offer(new Section(nx, ny, nk, poll.dist+1));
			}
		}
	}
	
	private static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= row || ny >= col;
	}

	static class Section {
		int x, y, k, dist;
		
        public Section (int x, int y, int k, int dist) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.dist = dist;
        }
	}
}