package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6191_CowsOnSkates {
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
		
		matrix = new char[row+1][col+1];
		visit = new boolean[row+1][col+1];
		
		for(int i = 1; i <= row; i++) {
			char[] input = br.readLine().toCharArray();
			
			for(int j = 1; j <= col; j++) {
				matrix[i][j] = input[j-1];
			}
		}
		
		bfs(1, 1);
	}
	
	public static void bfs(int i, int j) {
		Queue<Section> q = new ArrayDeque<>();
		
		q.offer(new Section(i, j, i+" "+j+"\n"));
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			Section poll = q.poll();
			
			if(poll.x == row && poll.y == col) {
				System.out.println(poll.history.toString().trim());
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll.x + dx[delta];
				int ny = poll.y + dy[delta];
				
				if(nx > 0 && ny > 0 && nx <= row && ny <= col && !visit[nx][ny] && matrix[nx][ny] == '.') {
					q.offer(new Section(nx, ny, poll.history + nx + " " + ny + "\n"));
					visit[nx][ny] = true;
				}
			}
		}
	}

	static class Section {
        int x;
        int y;
        String history;

        public Section(int x, int y, String history) {
            this.x = x;
            this.y = y;
            this.history = history;
        }
    }
}
