package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18404_현명한나이트 {
	static int row, col;
	static boolean matrix[][];
	static boolean visit[][];
	static int cost[][];
	
	static final int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
	static final int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        row = Integer.parseInt(st.nextToken());
        col = row;
        
        cost = new int[row][col];
        matrix = new boolean[row][col];
        visit = new boolean[row][col];
        
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine() , " ");
        int startX = Integer.parseInt(st.nextToken())-1;
        int startY = Integer.parseInt(st.nextToken())-1;
        
        bfs(startX, startY);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	sb.append(cost[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]+" ");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void bfs(int startX, int startY) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {startX, startY, 0});
		visit[startX][startY] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			cost[poll[0]][poll[1]] = poll[2];
			
			for(int delta = 0; delta < 8; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny]) {
					q.offer(new int[] {nx, ny, poll[2]+1});
					visit[nx][ny] = true;
				}
			}
		}
	}
}