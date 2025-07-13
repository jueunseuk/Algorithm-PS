package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5847_MilkScheduling {
	static int n, m;
	static List<List<Integer>> list = new ArrayList<>();
	static int top[];
	static int dp[];
	static int req[];
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        top = new int[n+1];
        dp = new int[n+1];
        req = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 1; i <= n; i++) {
        	req[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(end);
        	top[end]++;
        }
        
        top();
        
        int max = 0;
        for(int out : dp) {
        	max = Math.max(max, out);
        }
        
        System.out.println(max);
	}

	private static void top() {
		Queue<int[]> q = new ArrayDeque<>();
		
		for(int i = 1; i <= n; i++) {
			if(top[i] == 0) {
				q.offer(new int[] {i, req[i]});
				dp[i] = req[i];
			}
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int out : list.get(poll[0])) {
				dp[out] = Math.max(dp[out], req[out] + poll[1]);
				if(--top[out] == 0) {
					q.offer(new int[] {out, dp[out]});
				}
			}
		}
	}
}