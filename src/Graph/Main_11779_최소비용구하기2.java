package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11779_최소비용구하기2 {
	static final int INF = 1000000000;
	
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static int cost[];
	static int dir[];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        cost = new int[n+1];
        dir = new int[n+1];
        
        Arrays.fill(cost, INF);
        Arrays.fill(dir, -1);
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        StringTokenizer st;
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new int[] {end, c});
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        dijkstra(start, end);
        
        List<Integer> path = new ArrayList<>();
        for (int v = end; v != 0; v = dir[v]) {
            path.add(v);
            if (v == start) break;
        }
        Collections.reverse(path);

        System.out.println(cost[end]);
        System.out.println(path.size());
        
        StringBuilder sb = new StringBuilder();
        for (int v : path) sb.append(v + " ");
        
        System.out.println(sb.toString().trim());
	}

	private static void dijkstra(int start, int end) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1]-b[1]);
		
		q.offer(new int[] {start, 0});
		cost[start] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == end) {
				return;
			}
			
			if(poll[1] > cost[poll[0]]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int c = poll[1] + out[1];
				if(cost[out[0]] > c) {
					q.offer(new int[] {out[0], c});
					cost[out[0]] = c;
					dir[out[0]] = poll[0];
				}
			}
		}
	}
}