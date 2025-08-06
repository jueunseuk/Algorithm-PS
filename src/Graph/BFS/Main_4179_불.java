package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_4179_불 {
	static int row, col;
	static char matrix[][];
	static boolean visit[][];
	
	static ArrayDeque<Section> q;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	static StringBuilder result = new StringBuilder();
	static final String MESSAGE = "IMPOSSIBLE";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new char[row][col];
		visit = new boolean[row][col];
		
		q = new ArrayDeque<>();
		
		for(int i = 0; i < row; i++) {
			matrix[i] = br.readLine().toCharArray();
			
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] == 'J') {
					q.offerLast(new Section(i, j, 0, false));
					matrix[i][j] = '.';
					visit[i][j] = true;
				} else if(matrix[i][j] == 'F') {
					q.offerFirst(new Section(i, j, 0, true));
				}
			}
		}
		
		bfs();
		
		br.close();
		
		System.out.println(result.toString().trim());
	}
	
	public static void bfs() {
        while (!q.isEmpty()) {
            Section poll = q.poll();

            for (int delta = 0; delta < 4; delta++) {
                int nx = poll.x + dx[delta];
                int ny = poll.y + dy[delta];

                if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                    if (!poll.isFire) {
                        result.append(poll.time + 1);
                        return;
                    }
                    continue;
                }

                if (matrix[nx][ny] == '.') {
                    matrix[nx][ny] = poll.isFire ? 'F' : 'J';
                    q.offer(new Section(nx, ny, poll.time + 1, poll.isFire));
                    if (!poll.isFire) {
                        visit[nx][ny] = true;
                    }
                }
            }
        }

        result.append(MESSAGE);
    }

    static class Section {
        int x;
        int y;
        int time;
        boolean isFire;

        public Section(int x, int y, int time, boolean isFire) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.isFire = isFire;
        }
    }
}