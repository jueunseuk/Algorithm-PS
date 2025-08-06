package Graph.Dijkstra;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_33906_점심나가서먹기 {
	static final int INF = 1000000000;
	
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static int cost[];
	static int cost2[];
	static Pair rice[];
	static Pair cafe[];

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
		
		n = rd.nextInt();
		m = rd.nextInt();
		
		rice = new Pair[n];
		cafe = new Pair[n];
		
		for(int i = 0; i < n; i++) {
			rice[i] = new Pair(i+1, rd.nextInt());
		}
		
		for(int i = 0; i < n; i++) {
			cafe[i] = new Pair(i+1, rd.nextInt());
		}
		
		Arrays.sort(rice);
		Arrays.sort(cafe);
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			int start = rd.nextInt();
			int end = rd.nextInt();
			int c = rd.nextInt();
			
			list.get(start).add(new int[] {end, c});
			list.get(end).add(new int[] {start, c});
		}
		
		dijkstra(1);
		
		int cafeX = 0;
		for (Pair p : cafe) {
		    if (p.price == 0) continue;
		    if (cost[p.idx] != INF) {
		        cafeX = p.idx;
		        break;
		    }
		}

		int riceX = 0;
		for (Pair p : rice) {
		    if (p.price == 0) continue;
		    if (cost[p.idx] != INF) {
		        riceX = p.idx;
		        break;
		    }
		}
		
		subDijkstra(cafeX, riceX);
		
		long result = (long) cost[riceX] + cost[cafeX] + cost2[cafeX];
		System.out.println(result);
	}

	private static void subDijkstra(int cafeX, int riceX) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		cost2 = new int[n+1];
		Arrays.fill(cost2, INF);
		
		q.offer(new int[] {riceX, 0});
		cost2[riceX] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] > cost2[poll[0]]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int nc = poll[1] + out[1];
				if(cost2[out[0]] > nc) {
					q.offer(new int[] {out[0], nc});
					cost2[out[0]] = nc;
				}
			}
		}
		
	}

	private static void dijkstra(int i) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		cost = new int[n+1];
		Arrays.fill(cost, INF);
		
		q.offer(new int[] {i, 0});
		cost[i] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] > cost[poll[0]]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int nc = poll[1] + out[1];
				if(cost[out[0]] > nc) {
					q.offer(new int[] {out[0], nc});
					cost[out[0]] = nc;
				}
			}
		}
	}
	
	static class Pair implements Comparable<Pair> {
		int idx;
		int price;
		
		public Pair(int idx, int price) {
			this.idx = idx;
			this.price = price;
		}

		@Override
		public int compareTo(Pair o) {
			return this.price - o.price;
		}
	}
	
	static class Reader {
	    private final int SIZE = 1 << 13;
	    private byte[] buffer = new byte[SIZE];
	    private int index, size;
	    
	    int nextInt() throws Exception {
	        int lis = 0;
	        byte c;
	        boolean isMinus = false;
	        while ((c = read()) <= 32);
	        if (c == 45) { c = read(); isMinus = true; }
	        do lis = (lis << 3) + (lis << 1) + (c & 15);
	        while (isnumber(c = read()));
	        return isMinus ? ~lis + 1 : lis;
	    }

	    private boolean isnumber(byte c) {
	        return 47 < c && c < 58;
	    }

	    private byte read() throws Exception {
	        if (index == size) {
	            size = System.in.read(buffer, index = 0, SIZE);
	            if (size < 0) buffer[0] = -1;
	        }
	        return buffer[index++];
	    }
	}
}