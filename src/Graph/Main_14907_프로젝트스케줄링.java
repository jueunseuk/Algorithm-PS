package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14907_프로젝트스케줄링 {
	static int n = 26;
	static List<List<Integer>> list = new ArrayList<>();
	static int top[];
	static int dp[];
	static int req[];
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 26; i++) {
        	list.add(new ArrayList<>());
    	}
        
        top = new int[n];
        dp = new int[n];
        req = new int[n];
        
        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) break;
            
            StringTokenizer st = new StringTokenizer(line, " ");
        	
        	int end = st.nextToken().charAt(0) - 'A';
        	int c = Integer.parseInt(st.nextToken());
        	
        	if(st.hasMoreTokens()) {
        		char start[] = st.nextToken().toCharArray();
        		for(int i = 0; i < start.length; i++) {
        			list.get(start[i] - 'A').add(end);
        			top[end]++;
        		}
        	}
        	
        	req[end] = c;
        }
        
        top();
        
        
        
        int max = 0;
        for(int out : dp) {
        	max = Math.max(out, max);
        }
        
        System.out.println(max);
	}

	private static void top() {
		Queue<int[]> q = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			if(top[i] == 0) {
				q.offer(new int[] {i, req[i]});
				dp[i] = req[i];
			}
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int out : list.get(poll[0])) {
				dp[out] = Math.max(dp[out], poll[1] + req[out]);
				if(--top[out] == 0) {
					q.offer(new int[] {out, dp[out]});
				}
			}
		}
	}
}