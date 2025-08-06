package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16397_탈출 {
	static boolean[] visit = new boolean[100001];
	static int[] pre = {1, 10, 100, 1000, 10000, 100000};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        
        bfs(n, t, target);
        
        System.out.println("ANG");
	}

	private static void bfs(int n, int t, int target) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {n, 0});
		visit[n] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] > t) {
				return;
			}
			
			if(poll[0] == target) {
				System.out.println(poll[1]);
				System.exit(0);
			}
			
			int plus = poll[0]+1;
			
			if(plus < 100000 && !visit[plus]) {
				q.offer(new int[] {plus, poll[1]+1});
				visit[plus] = true;
			}
			
			int multi = poll[0] << 1;
			if(multi >= 100000 || multi == 0) {
				continue;
			}
			
			for(int i = 0; i < 6; i++) {
				if(multi % pre[i] == multi) {
					multi -= pre[i-1];
					break;
				}
			}
			
			if(multi < 100000 && !visit[multi]) {
				q.offer(new int[] {multi, poll[1]+1});
				visit[multi] = true;
			}
		}
	}
}