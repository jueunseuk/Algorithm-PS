package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_24846_ArmyofClones {
	static int n, m, clone;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] cost;
	static int[] droid;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        cost = new int[n+1];
        droid = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(end);
        	list.get(end).add(start);
        }
        
        clone = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) {
        	droid[i] = Integer.parseInt(st.nextToken());
        }
        
        bfs(1, n);
        
        System.out.println(cost[n]);
	}

	private static void bfs(int i, int j) {
		Deque<int[]> q = new ArrayDeque<>();
		
		if(clone > droid[1]) {
			q.offer(new int[] {i, clone});
			cost[i] = clone;
		} else {
			q.offer(new int[] {i, clone/2});
			cost[i] = clone/2;
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int out : list.get(poll[0])) {
				if(cost[out] < poll[1]) {
					if(droid[out] < poll[1]) {
						q.offerFirst(new int[] {out, poll[1]});
						cost[out] = Math.max(cost[out], poll[1]);
					} else {
						q.offerLast(new int[] {out, poll[1]/2});
						cost[out] = Math.max(cost[out], poll[1]/2);
					}
				}
			}
		}
	}
}