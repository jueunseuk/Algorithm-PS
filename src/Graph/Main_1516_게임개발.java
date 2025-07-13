package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1516_게임개발 {
	static int n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] top;
    static int[] req;
    static int[] dp;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        top = new int[n+1];
        req = new int[n+1];
        dp = new int[n+1];
        
        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	req[i] = Integer.parseInt(st.nextToken());
        	
        	while(true) {
        		int input = Integer.parseInt(st.nextToken());
        		if(input == -1) break;
        		list.get(input).add(i);
        		top[i]++;
        	}
        }
        
        top();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
        	sb.append(dp[i]+"\n");
        }
        
        System.out.println(sb.toString().trim());
	}

    private static void top() {
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 1; i <= n; i++) {
            if(top[i] == 0) {
                q.offer(i);
                dp[i] = req[i];
            }
        }

        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int out : list.get(poll)) {
                dp[out] = Math.max(dp[out], dp[poll] + req[out]);
                if (--top[out] == 0) q.offer(out);
            }
        }
    }
}