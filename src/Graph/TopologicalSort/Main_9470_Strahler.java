package Graph.TopologicalSort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9470_Strahler {
	static int n, tc, m;
    static List<List<Integer>> list;
    static int[] top;
    static int[][] order;
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	tc = Integer.parseInt(st.nextToken());
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	
        	top = new int[n+1];
        	order = new int[n+1][2];
        	
        	list = new ArrayList<>();
        	for(int i = 0; i <= n; i++) {
        		list.add(new ArrayList<>());
        	}
        	
        	for(int i = 0; i < m; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int start = Integer.parseInt(st.nextToken());
        		int end = Integer.parseInt(st.nextToken());
        		
        		list.get(start).add(end);
        		top[end]++;
        	}
        	
        	topologicalSort();
        	
        	sb.append(tc).append(" ").append(order[n][0]).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void topologicalSort() {
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1; i <= n; i++) {
			if(top[i] == 0) {
				q.offer(i);
				order[i][0] = 1;
				order[i][1] = 1;
			}
		}
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			if(order[poll][1] > 1) {
				order[poll][0]++;
				order[poll][1] = 1;
			}
			
			for(int out : list.get(poll)) {
				if(order[out][0] < order[poll][0]) {
					order[out][0] = order[poll][0];
					order[out][1] = 1;
				} else if(order[out][0] == order[poll][0]) {
					order[out][1]++;
				}
				
				if(--top[out] == 0) {
					q.offer(out);
				}
			}
		}
	}
}