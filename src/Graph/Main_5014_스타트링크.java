package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5014_스타트링크 {
	static int f, s, g, u, d;
	static int[] matrix;
	static boolean[] visit;
	
	static int dx[] = new int[2];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        matrix = new int[f+1];
        visit = new boolean[f+1];
        
        dx[0] = u;
        dx[1] = -d;
        
        bfs();

        System.out.println("use the stairs");
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {s, 0});
		visit[s] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == g) {
				System.out.println(poll[1]);
				System.exit(0);
			}
			
			for(int delta = 0; delta < 2; delta++) {
				int nx = poll[0] + dx[delta];
				
				if(nx > 0 && nx <= f && !visit[nx]) {
					q.offer(new int[] {nx, poll[1]+1});
					visit[nx] = true;
				}
			}
		}
	}
}