package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_32188_PortalGame {
	static final int INF = 100000000;
	
	static int n, c;
	static int[] cost;
	static Portal[] list;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        list = new Portal[n];
        
        for(int i = 0; i < c; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int type = Integer.parseInt(st.nextToken());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	list[start] = new Portal(type, start, end);
        }
        
        zoBfs();
        
        System.out.println(cost[n-1] == INF ? -1 : cost[n-1]);
	}
	
	private static void zoBfs() {
		Deque<Integer> deq = new ArrayDeque<>();
		cost = new int[n];
		Arrays.fill(cost, INF);
		
		deq.offer(0);
		cost[0] = 0;
		
		while(!deq.isEmpty()) {
			int cur = deq.poll();
			
			if(cur == n-1) continue;
			
			Portal now = list[cur];
			
			if(now == null) {
				if(cur + 1 < n && cost[cur + 1] > cost[cur] + 1) {
					cost[cur + 1] = cost[cur] + 1;
					deq.offerLast(cur + 1);
				}
			} else if(now.type == 0) {
				if(cost[now.end] > cost[cur]) {
					cost[now.end] = cost[cur];
					deq.offerFirst(now.end);
				}
			} else {
				if(cost[now.end] > cost[cur]) {
					cost[now.end] = cost[cur];
					deq.offerFirst(now.end);
				}
				
				if(cur + 1 < n && cost[cur + 1] > cost[cur] + 1) {
					cost[cur + 1] = cost[cur] + 1;
					deq.offerLast(cur + 1);
				}
			}
		}
	}

	static class Portal {
		int type;
		int start;
		int end;
		
		public Portal(int type, int start, int end) {
			this.type = type;
			this.start = start;
			this.end = end;
		}
	}
}