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

public class Main_14630_변신로봇 {
	static final int INF = 1000000000;
	
	static int n, length;
	static List<List<int[]>> list = new ArrayList<>();
	static String save[];
	static int cost[];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        save = new String[n+1];
        for(int i = 1; i <= n; i++) {
        	save[i] = br.readLine();
        }
        
        length = save[1].length();
        
        for(int i = 1; i <= n; i++) {
        	for(int j = i+1; j <= n; j++) {
        		int dist = calcDist(save[i], save[j]);
        		list.get(i).add(new int[] {j, dist});
        		list.get(j).add(new int[] {i, dist});
        	}
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        dijkstra(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	}

	private static int calcDist(String a, String b) {
		int sum = 0;
		for(int i = 0; i < length; i++) {
			int tmp = (a.charAt(i)-'0') - (b.charAt(i)-'0');
			sum += tmp*tmp;
		}
		return sum;
	}
	
	private static void dijkstra(int i, int j) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		cost = new int[n+1];
		Arrays.fill(cost, INF);
		
		q.offer(new int[] {i, 0});
		cost[i] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == j) {
				System.out.println(poll[1]);
				return;
			}
			
			if(poll[1] > cost[poll[0]]) continue;
			
			for(int[] out : list.get(poll[0])) {				
				int nc = poll[1] + out[1];
				if(nc < cost[out[0]]) {
					q.offer(new int[] {out[0], nc});
					cost[out[0]] = nc;
				}
			}
		}
	}
}