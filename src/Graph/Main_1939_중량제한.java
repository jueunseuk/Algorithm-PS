package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1939_중량제한 {
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static int cost[];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        cost = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new int[] {end, c});
        	list.get(end).add(new int[] {start, c});
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        bfs(start, end);
        
        System.out.println(cost[end]);
	}

	private static void bfs(int start, int end) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		
		q.offer(new int[] {start, Integer.MAX_VALUE});
		cost[start] = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if (poll[1] < cost[poll[0]]) continue;

			for(int[] out : list.get(poll[0])) {
				int min = Math.min(poll[1], out[1]);
				if(cost[out[0]] < min) {
					q.offer(new int[] {out[0], min});
					cost[out[0]] = min;
				}
			}
		}
	}
}