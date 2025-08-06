package Graph.TopologicalSort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2637_장난감조립 {
	static int n, m;
    static List<List<int[]>> list = new ArrayList<>();
    static int[] top;
    static int[] req;
    static int[] dp;
    
    static List<Integer> result = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        top = new int[n+1];
        dp = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        StringTokenizer st;
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new int[] {end, c});
        	top[end]++;
        }
        
        topologicalSort();
        
        Collections.sort(result);
        
        StringBuilder sb = new StringBuilder();
        for(int out : result) {
        	sb.append(out+" "+dp[out]+"\n");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void topologicalSort() {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(n);
		dp[n] = 1;
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			if(list.get(poll).size() == 0) {
				result.add(poll);
				continue;
			}
			
			for(int[] out : list.get(poll)) {
				dp[out[0]] += dp[poll] * out[1];
				if(--top[out[0]] == 0) {
					q.offer(out[0]);
				}
			}
		}
	}
}