package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2611_자동차경주 {
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static int top[];
	static int dp[];
	static int prev[];
	
	static StringBuilder sb = new StringBuilder();
	static List<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        top = new int[n+1];
        dp = new int[n+1];
        prev = new int[n+1];
        
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
        
        System.out.println(dp[1]);
        
        for(int out : result) {
        	sb.append(out+" ");
        }
        System.out.println(sb.toString().trim());
	}

	private static void topologicalSort() {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {1, 0});
		dp[1] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int[] out : list.get(poll[0])) {
				if(dp[out[0]] < poll[1]+out[1]) {
					dp[out[0]] = poll[1]+out[1];
					prev[out[0]] = poll[0];
				}
				
				if(--top[out[0]] == 0) {
					q.offer(new int[] {out[0], dp[out[0]]});
				}
			}
		}
	}
}