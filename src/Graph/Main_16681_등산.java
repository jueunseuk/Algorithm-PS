package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16681_등산 {
	static int n, m, consume, accomp;
	static int[] height;
	static long[] cost;
	static long[] cost2;
	static List<List<int[]>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        consume = Integer.parseInt(st.nextToken());
        accomp = Integer.parseInt(st.nextToken());
        
        height = new int[n+1];
        cost = new long[n+1];
        cost2 = new long[n+1];
        Arrays.fill(cost, -1);
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	height[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new int[] {end, c});
        	list.get(end).add(new int[] {start, c});
        }
        
        dijkstraFirst(1);
        dijkstraSecond(n);
	}

	private static void dijkstraSecond(int start) {
		Queue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, 0));
		cost[start] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(cost[poll.node] < poll.weight) continue;
			
			for(int[] out : list.get(poll.node)) {
				long nc = out[1] + poll.weight;
				if(cost[out[0]] > nc) {
					q.offer(new Node(out[0], nc));
					cost[out[0]] = nc;
				}
			}
		}
	}

	private static void dijkstraFirst(int start) {
		Queue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, 0));
		cost[start] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(cost[poll.node] < poll.weight) continue;
			
			for(int[] out : list.get(poll.node)) {
				if(height[out[0]] <= height[poll.node]) {
					continue;
				}
				
				long nc = out[1] + poll.weight;
				if(cost[out[0]] > nc) {
					q.offer(new Node(out[0], nc));
					cost[out[0]] = nc;
				}
			}
		}
	}

	static class Node implements Comparator<Node> {
		int node;
		long weight;

		public Node(int node, long weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compare(Node o1, Node o2) {
			return Long.compare(o1.weight, o2.weight);
		}
	}
}