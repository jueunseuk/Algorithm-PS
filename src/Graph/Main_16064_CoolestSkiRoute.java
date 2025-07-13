package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16064_CoolestSkiRoute {
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static int top[];
	static int dp[];
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        top = new int[n+1];
        dp = new int[n+1];
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new int[] {end, c});
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
				q.offer(new int[] {i, 0});
				dp[i] = 0;
			}
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int[] out : list.get(poll[0])) {
				dp[out[0]] = Math.max(dp[out[0]], out[1] + poll[1]);
				if(--top[out[0]] == 0) {
					q.offer(new int[] {out[0], dp[out[0]]});
				}
			}
		}
	}
}