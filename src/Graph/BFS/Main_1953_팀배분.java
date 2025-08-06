package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1953_팀배분 {
	static int n;
	static List<List<Integer>> list = new ArrayList<>();
	static int visit[];
	
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    	n = Integer.parseInt(br.readLine());
    	
    	visit = new int[n+1];
    	for(int i = 0; i <= n; i++) {
    		list.add(new ArrayList<>());
    	}
    	
    	StringTokenizer st;
    	for(int i = 1; i <= n; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		
    		int temp = Integer.parseInt(st.nextToken());
    		for(int j = 0; j < temp; j++) {
    			list.get(i).add(Integer.parseInt(st.nextToken()));
    		}
    	}
    	
    	for(int i = 1; i <= n; i++) {
    		if(visit[i] == 0) {
    			bfs(i);
    		}
    	}
    	
    	int alpha = 0, beta = 0;
    	StringBuilder one = new StringBuilder();
    	StringBuilder two = new StringBuilder();
    	for(int i = 1; i <= n; i++) {
    		if(visit[i] == 1) {
    			alpha++;
    			one.append(i+" ");
    		} else {
    			beta++;
    			two.append(i+" ");
    		}
    	}
    	
    	System.out.println(alpha);
    	System.out.println(one.toString().trim());
    	System.out.println(beta);
    	System.out.println(two.toString().trim());
	}

	private static void bfs(int i) {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(i);
		visit[i] = 1;
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int out : list.get(poll)) {
				if(visit[out] == 0) {
					q.offer(out);
					visit[out] = -visit[poll];
				} else if(visit[out] == visit[poll]) {
					return;
				}
			}
		}
	}
}