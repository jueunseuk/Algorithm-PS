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

public class Main_16118_달빛여우 {
	static final int INF = Integer.MAX_VALUE;
	
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static int[] fox;
	static int[][] wolf;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        fox = new int[n+1];
        wolf = new int[n+1][2];
        Arrays.fill(fox, INF);
        for(int i = 0; i <= n; i++) {
        	Arrays.fill(wolf[i], INF);
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken())*2;
        	
        	list.get(start).add(new int[] {end, c});
        	list.get(end).add(new int[] {start, c});
        }
        
        dijkstraForWolf(1);
        dijkstraForFox(1);
        
        int cnt = 0;
        for(int i = 2; i <= n; i++) {
        	if(fox[i] < Math.min(wolf[i][0], wolf[i][1])) {
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
	}

	private static void dijkstraForWolf(int i) {
		Queue<Node> q = new PriorityQueue<>();
		
		q.offer(new Node(i, 0, 0));
		wolf[i][0] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();			
			
			int parity = poll.cnt & 1;
			if (poll.weight > wolf[poll.node][parity]) continue;
			
			for(int[] out : list.get(poll.node)) {
				int next = 1 - poll.cnt;
				int c = poll.cnt == 0 ? poll.weight + out[1]/2 : poll.weight + out[1]*2;
				
				if(wolf[out[0]][next] > c) {
					wolf[out[0]][next] = c;
					q.offer(new Node(out[0], c, next));
				}
			}
		}
	}

	private static void dijkstraForFox(int i) {
		Queue<Node> q = new PriorityQueue<>();
		
		q.offer(new Node(i, 0, 0));
		fox[i] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.weight > fox[poll.node]) continue; 
			
			for(int[] out : list.get(poll.node)) {
				if(fox[out[0]] > poll.weight + out[1]) {
					fox[out[0]] = poll.weight + out[1];
					q.offer(new Node(out[0], poll.weight + out[1], 0));
				}
			}
		}
	}
	
	public static class Node implements Comparable<Node> {
		int node;
		int weight;
		int cnt;
		
		public Node(int node, int weight, int cnt) {
			this.node = node;
			this.weight = weight;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}