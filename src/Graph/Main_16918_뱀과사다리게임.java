package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16918_뱀과사다리게임 {
	static int matrix[] = new int[101];
	static boolean[] visit = new boolean[101];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int ladder = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= 100; i++) {
			matrix[i] = i;
		}
		
		// 사다리+뱀 초기화
		for(int i = 0; i < ladder+snake; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			matrix[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());	
		}
		
		bfs(1);

	}

	public static void bfs(int i) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, 0});
		visit[i] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == 100) {
				System.out.println(poll[1]);
				return;
			}
			
			for(int delta = 1; delta <= 6; delta++) {
				int nx = poll[0] + delta;
				
				if(nx > 100) continue;
				
				nx = matrix[nx];
				
				if(!visit[nx]) {
					visit[nx] = true;
					q.offer(new int[] {nx, poll[1]+1});
				}
			}
		}	
	}
}