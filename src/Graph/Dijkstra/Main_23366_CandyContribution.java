package Graph.Dijkstra;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_23366_CandyContribution {
	
	static int n, m, s, t, init;
	static List<List<int[]>> list = new ArrayList<>();
	static long[] cost;

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
        
        n = rd.nextInt();
        m = rd.nextInt();
        s = rd.nextInt();
        t = rd.nextInt();
        init = rd.nextInt();
        
        cost = new long[n+1];
        Arrays.fill(cost, -1);
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	int start = rd.nextInt();
        	int end = rd.nextInt();
        	int c = 100 - rd.nextInt();
        	
        	list.get(start).add(new int[] {end, c});
        	list.get(end).add(new int[] {start, c});
        }
        
        dijkstra();
	}

	private static void dijkstra() {
		Queue<Node> q = new PriorityQueue<>();
		
		q.offer(new Node(s, init));
		cost[s] = init;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.v == t) {
				System.out.println(poll.candy);
				break;
			}
			
			if(poll.candy < cost[poll.v]) continue;
			
			for (int[] e : list.get(poll.v)) {
	            long next = (poll.candy * e[1]) / 100;
	            if (next > cost[e[0]]) {
	                cost[e[0]] = next;
	                q.add(new Node(e[0], next));
	            }
	        }
		}
	}
	
	static class Node implements Comparable<Node> {
		int v;
		long candy;
		
		public Node(int v, long candy) {
			this.v = v;
			this.candy = candy;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(o.candy, this.candy);
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