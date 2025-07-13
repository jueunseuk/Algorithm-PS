package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10282_해킹 {
	static final int INF = 100000000;
	
	static int n, m;
	static List<List<int[]>> list;
	static int cost[];
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	int start = Integer.parseInt(st.nextToken());
        	
        	list = new ArrayList<>();
        	cost = new int[n+1];
        	
        	Arrays.fill(cost, INF);
        	
        	for(int i = 0; i <= n; i++) {
        		list.add(new ArrayList<>());
        	}
        	
        	for(int i = 0; i < m; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int s = Integer.parseInt(st.nextToken());
        		int e = Integer.parseInt(st.nextToken());
        		list.get(e).add(new int[] {s, Integer.parseInt(st.nextToken())});
        	}
        	
        	bfs(start);
        }

        System.out.println(sb.toString().trim());
	}

	private static void bfs(int start) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		
		q.offer(new int[] {start, 0});
		cost[start] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int[] out : list.get(poll[0])) {
				if(cost[out[0]] > out[1] + poll[1]) {
					cost[out[0]] = out[1] + poll[1];
					q.offer(new int[] {out[0], out[1] + poll[1]});
				}
			}
		}
		
		int cnt = 0, max = 0;
		for(int out : cost) {
			if(out != INF) {
				cnt++;
				max = Math.max(max, out);
			}
		}
		
		sb.append(cnt+" ");
		sb.append(max+"\n");
	}
}