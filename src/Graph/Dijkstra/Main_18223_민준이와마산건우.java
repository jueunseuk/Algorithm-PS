package Graph.Dijkstra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18223_민준이와마산건우 {
	static final int INF = 100000000;
	
	static int n, m, stopover;
	static List<List<int[]>> list = new ArrayList<>();
	static int cost[];
	static int cost2[];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        stopover = Integer.parseInt(st.nextToken());
        
        cost = new int[n+1];
        cost2 = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        Arrays.fill(cost, INF);
        Arrays.fill(cost2, INF);
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new int[] {end, c});
        	list.get(end).add(new int[] {start, c});
        }
        
        dijkstra(1);
        dijkstraWithCenter(stopover);
        
        if(cost[stopover] + cost2[n] <= cost[n]) {
        	System.out.println("SAVE HIM");
        } else {
        	System.out.println("GOOD BYE");
        }
	}

	private static void dijkstra(int i) {
		Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		q.offer(new int[] {i, 0});
		cost[i] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] > cost[poll[0]]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int temp = poll[1] + out[1];
				if(cost[out[0]] > temp) {
					q.offer(new int[] {out[0], temp});
					cost[out[0]] = temp;
				}
			}
		}
	}

	private static void dijkstraWithCenter(int i) {
		Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		q.offer(new int[] {i, 0});
		cost2[i] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] > cost2[poll[0]]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int temp = poll[1] + out[1];
				if(cost2[out[0]] > temp) {
					q.offer(new int[] {out[0], temp});
					cost2[out[0]] = temp;
				}
			}
		}
	}
}