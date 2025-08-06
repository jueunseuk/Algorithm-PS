package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10917_YourLife {
	static int n, m;
	static boolean visit[];
	static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	list.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
        
        bfs(1);
	}

	private static void bfs(int i) {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[n+1];
		
		q.offer(new int[] {i, 0});
		visit[i] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == n) {
				System.out.println(poll[1]);
				System.exit(0);;
			}
			
			for(int out : list.get(poll[0])) {
				if(!visit[out]) {
					q.offer(new int[] {out, poll[1]+1});
					visit[out] = true;
				}
			}
		}
		
		System.out.println(-1);
	}
}