package Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_9370_미확인도착지 {
	static final int INF = 1000000000;
	
	static int n, m, t, s, g, h;
	static List<List<int[]>> list;
	static int[] cost1;
	static int[] cost2;
	static int[] cost3;
	static int[] candidate;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
		
		int TC = rd.nextInt();
		
		for(int tc = 0; tc < TC; tc++) {
			n = rd.nextInt();
			m = rd.nextInt();
			t = rd.nextInt();
			s = rd.nextInt();
			g = rd.nextInt();
			h = rd.nextInt();
			
			cost1 = new int[n+1];
			cost2 = new int[n+1];
			cost3 = new int[n+1];
			
			list = new ArrayList<>();
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
			
			candidate = new int[t];
			for(int i = 0; i < t; i++) {
				candidate[i] = rd.nextInt();
			}
			
			dijkstra(s, cost1);
			dijkstra(g, cost2);
			dijkstra(h, cost3);
			
			List<Integer> result = new ArrayList<>();
			for(int i = 0; i < t; i++) {
				int target = candidate[i];
				if(cost1[target] == cost1[g] + cost2[target] && cost1[target] == cost1[h] + cost3[target]) {
					result.add(target);
				}
			}
			
			Collections.sort(result);
			for(int out : result) {
				sb.append(out+" ");
			}
			
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}

	private static void dijkstra(int i, int[] cost) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		Arrays.fill(cost, INF);
		
		cost[i] = 0;
		q.offer(new int[] {i, 0});
		
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