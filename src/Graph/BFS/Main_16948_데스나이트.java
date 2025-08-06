package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16948_데스나이트 {
	static int size, cnt = 0;
	static boolean visit[][];
	
	static int[] dx = {-2, -2, 0, 0, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -1, 1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        size = Integer.parseInt(br.readLine());
        visit = new boolean[size][size];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        
        bfs(x1, y1, x2, y2);
	}

	private static void bfs(int x1, int y1, int x2, int y2) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {x1, y1, 0});
		visit[x1][y1] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == x2 && poll[1] == y2) {
				System.out.println(poll[2]);
				return;
			}
			
			for(int delta = 0; delta < 6; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >=0 && nx < size && ny < size && !visit[nx][ny]) {
					q.offer(new int[] {nx, ny, poll[2]+1});
					visit[nx][ny] = true;
				}
			}
		}
		
		System.out.println(-1);
	}
}