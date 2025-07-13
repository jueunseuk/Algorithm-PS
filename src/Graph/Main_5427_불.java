package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5427_불 {
	static int row, col;
	static char matrix[][];
	static boolean visit[][];
	
	static Queue<Section> person;
	static Queue<Section> fire;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	static StringBuilder result = new StringBuilder();
	static final String MESSAGE = "IMPOSSIBLE";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			
			matrix = new char[row][col];
			visit = new boolean[row][col];
			
			person = new ArrayDeque<>();
			fire = new ArrayDeque<>();
			
			for(int i = 0; i < row; i++) {
				matrix[i] = br.readLine().toCharArray();
				
				for(int j = 0; j < col; j++) {
					if(matrix[i][j] == '@') {
						person.offer(new Section(i, j, 0));
						matrix[i][j] = '.';
						visit[i][j] = true;
					} else if(matrix[i][j] == '*') {
						fire.offer(new Section(i, j, 0));
					}
				}
			}
			
			bfs();
		}
		
		br.close();
		
		System.out.println(result.toString().trim());
	}
	
	public static void bfs() {
		while(!person.isEmpty()) {
			int size = fire.size();
			
			for(int i = 0; i < size; i++) {
				Section poll = fire.poll();
				
				for(int delta = 0; delta < 4; delta++) {
					int nx = poll.x + dx[delta];
					int ny = poll.y + dy[delta];
					
					if(nx >= 0 && ny >= 0 && nx < row && ny < col && matrix[nx][ny] == '.') {
						matrix[nx][ny] = '*';
						fire.offer(new Section(nx, ny, poll.time+1));
					}
				}
			}
			
			size = person.size();
	        
	        for (int i = 0; i < size; i++) {
	            Section poll = person.poll();
	            
	            for (int delta = 0; delta < 4; delta++) {
	                int nx = poll.x + dx[delta];
	                int ny = poll.y + dy[delta];
	                
	                if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
	                    result.append(poll.time + 1).append("\n");
	                    return;
	                }
	                
	                if (!visit[nx][ny] && matrix[nx][ny] == '.') {
	                    visit[nx][ny] = true;
	                    person.offer(new Section(nx, ny, poll.time + 1));
	                }
	            }
	        }
		}
		
		result.append(MESSAGE).append("\n");
	}
	
	static class Section {
        int x;
        int y;
        int time;

        public Section(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}