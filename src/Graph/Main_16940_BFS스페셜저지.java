package Graph;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main_16940_BFS스페셜저지 {
	static int n, idx = 0;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean visit[];
	static int[] order;

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
		
		n = rd.nextInt();
		
		for(int i = 0; i <= n ; i++) {
			list.add(new ArrayList<>());
		}
		
		visit = new boolean[n+1];
		order = new int[n];
		
		for(int i = 0; i < n-1; i++) {
			int start = rd.nextInt();
			int end = rd.nextInt();
			
			list.get(start).add(end);
			list.get(end).add(start);
		}
		
		for(int i = 0; i < n; i++) {
			order[i] = rd.nextInt();
		}
		
		System.out.println(bfs() ? 1 : 0);
	}

	private static boolean bfs() {
		if (order[0] != 1) return false;
		
	    Queue<Integer> q = new ArrayDeque<>();
	    boolean[] isChild = new boolean[n + 1];

	    q.offer(order[0]);
	    visit[order[0]] = true;
	    idx = 1;

	    while (!q.isEmpty()) {
	        int cur = q.poll();

	        int cnt = 0;
	        for (int next : list.get(cur)) {
	            if (!visit[next]) {
	                isChild[next] = true;
	                cnt++;
	            }
	        }

	        for (int i = 0; i < cnt; i++) {
	            if (idx == n) return false;
	            int v = order[idx++];
	            if (!isChild[v]) return false;

	            isChild[v] = false;
	            visit[v] = true;
	            q.offer(v);
	        }
	    }
	    return idx == n;
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
