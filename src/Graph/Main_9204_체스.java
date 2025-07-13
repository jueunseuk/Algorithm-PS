package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9204_체스 {
	static boolean matrix[][];
	
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, 1, -1};
	
	static String[] prepareStr = {"A", "B", "C", "D", "E", "F", "G", "H"};
	static int[] prepareInt = {1, 2, 3, 4, 5 ,6, 7, 8};
	
	static StringBuilder sb = new StringBuilder();
	static final String MESSAGE = "Impossible";

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int t = 0 ; t < T; t++) {
        	matrix = new boolean[8][8];
        	
        	st = new StringTokenizer(br.readLine(), " ");
        	 
        	int startY = st.nextToken().charAt(0) - 'A';
        	int startX = Integer.parseInt(st.nextToken())-1;
        	int endY = st.nextToken().charAt(0) - 'A';
        	int endX = Integer.parseInt(st.nextToken())-1;
        	
        	bfs(startX, startY, endX, endY);
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void bfs(int i, int j, int endX, int endY) {
		Queue<Chess> q = new ArrayDeque<>();
		
		matrix[i][j] = true;
		q.offer(new Chess(i, j, 0, prepareStr[j]+" "+prepareInt[i]));
		
		while(!q.isEmpty()) {
			Chess poll = q.poll();
			
			if(poll.x == endX && poll.y == endY) {
				sb.append(poll.length).append(" ").append(poll.history).append("\n");
				return;
			}
			
			if(poll.length == 4) {
				continue;
			}
			
			for(int idx = 1; idx <= 8; idx++) {
				for(int delta = 0; delta < 4; delta++) {
					int nx = poll.x + dx[delta]*idx;
					int ny = poll.y + dy[delta]*idx;
					
					if(nx >= 0 && ny >= 0 && nx < 8 && ny < 8 && !matrix[nx][ny]) {
						matrix[nx][ny] = true;
						q.offer(new Chess(nx, ny, poll.length+1, poll.history+" "+prepareStr[ny]+" "+prepareInt[nx]));
					}
				}
			}
		}
		
		sb.append(MESSAGE).append("\n");
	}
	
	public static class Chess {
		int x;
		int y;
		int length;
		String history;
		
		public Chess(int x, int y, int length, String history) {
			this.x = x;
			this.y = y;
			this.length = length;
			this.history = history;
		}
	}
}