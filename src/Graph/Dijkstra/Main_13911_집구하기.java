package Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13911_집구하기 {
	static final int INF = 500000000;
	
	static int n, m, mc, st, rangem, ranges;
	static List<List<int[]>> list = new ArrayList<>();
	static int[] costm, costs;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer string = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(string.nextToken());
        m = Integer.parseInt(string.nextToken());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	string = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(string.nextToken());
        	int end = Integer.parseInt(string.nextToken());
        	int c = Integer.parseInt(string.nextToken());
        	
        	list.get(start).add(new int[] {end, c});
        	list.get(end).add(new int[] {start, c});
        }
        
        string = new StringTokenizer(br.readLine(), " ");
        mc = Integer.parseInt(string.nextToken());
        rangem = Integer.parseInt(string.nextToken());
        int[] mcs = new int[mc];
        
        string = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < mc; i++) {
        	mcs[i] = Integer.parseInt(string.nextToken());
        }
        
        string = new StringTokenizer(br.readLine(), " ");
        st = Integer.parseInt(string.nextToken());
        ranges = Integer.parseInt(string.nextToken());
        int[] sts = new int[st];
        
        string = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < st; i++) {
        	sts[i] = Integer.parseInt(string.nextToken());
        }
        
        costm = new int[n+1];
        dijkstra(mcs, costm, rangem);

        costs = new int[n+1];
        dijkstra(sts, costs, ranges);
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
        	if(costs[i] == 0 || costm[i] == 0 || costs[i] >= INF || costm[i] >= INF) continue;
        	min = Math.min(min, costs[i]+costm[i]);
        }
        
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void dijkstra(int[] candidate, int[] cost, int limit) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		Arrays.fill(cost, INF);
		
		for(int out : candidate) {
			q.offer(new int[] {out, 0});
			cost[out] = 0;
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] > cost[poll[0]]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int nc = out[1] + poll[1];
				if(nc > limit || nc > cost[out[0]]) continue;
				
				q.offer(new int[] {out[0], nc});
				cost[out[0]] = nc;
			}
		}
	}
}