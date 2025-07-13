package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14248_점프점프 {
	static int n;
	static int input[];
	static boolean visit[];
	
	static int dx[] = {1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        input = new int[n+1];
        visit = new boolean[n+1];
        
        for(int i = 1; i <= n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = Integer.parseInt(br.readLine());
        
        bfs(start);

	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		visit[start] = true;
		
		int cnt = 1;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int delta = 0; delta < 2; delta++) {
				int nx = poll+dx[delta]*input[poll];
				
				if(nx > 0 && nx <= n && !visit[nx]) {
					q.offer(nx);
					visit[nx] = true;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}