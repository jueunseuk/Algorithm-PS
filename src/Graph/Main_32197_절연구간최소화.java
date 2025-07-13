package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_32197_절연구간최소화 {
	static final int INF = 10000000;
	
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static int[][] cost;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        cost = new int[n+1][2];
        for(int i = 0; i <= n; i++) {
        	Arrays.fill(cost[i], INF);
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
        
        bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	}

	private static void bfs(int i, int j) {
		Deque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, 1});
		q.offer(new int[] {i, 0});
		cost[i][0] = 0;
		cost[i][1] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.pollFirst();
			
			for(int[] out : list.get(poll[0])) {
				int type = poll[1] == out[1] ? 0 : 1;
				if(cost[poll[0]][poll[1]] + type < cost[out[0]][out[1]]) {
					cost[out[0]][out[1]] = cost[poll[0]][poll[1]] + type;
					if(type == 0) {
						q.offerFirst(new int[] {out[0], out[1]});
					} else {
						q.offerLast(new int[] {out[0], out[1]});
					}
				}
			}
		}
		
		System.out.println(Math.min(cost[j][0], cost[j][1]));
	}
}