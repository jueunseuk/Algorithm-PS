package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6618_숨바꼭질 {
	static int n, m;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean visit[];

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
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(end);
        	list.get(end).add(start);
        }
        
        bfs(1);
	}

	private static void bfs(int i) {
		Queue<Integer> pq = new PriorityQueue<>();
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[n+1];
		
		q.offer(new int[] {i, 0});
		visit[i] = true;
		
		int dist = 0, cnt = 1;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] > dist) {
				pq = new PriorityQueue<>();
				pq.offer(poll[0]);
				cnt = 1;
				dist = poll[1];
			} else if(poll[1] == dist) {
				pq.offer(poll[0]);
				cnt++;
			}
			
			for(int out : list.get(poll[0])) {
				if(!visit[out]) {
					q.offer(new int[] {out, poll[1]+1});
					visit[out] = true;
				}
			}
		}
		
		System.out.println(pq.poll()+" "+dist+" "+cnt);
	}
}