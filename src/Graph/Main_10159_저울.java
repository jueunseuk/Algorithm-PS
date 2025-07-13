package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10159_저울 {
	static final int INF = 1000000;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int [][]result = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
        	Arrays.fill(result[i], INF);
        	result[i][i] = 0;
        }
        
        StringTokenizer st;
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	result[start][end] = 1;
        	result[end][start] = INF;
        }
        
        for(int k = 1; k <= n; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
        			result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
        	int cnt = 0;
        	for(int j = 1; j <= n; j++) {
        		if(i == j) continue;
        		
        		if(result[i][j] >= INF && result[j][i] >= INF) {
        			cnt++;
        		}
        	}
        	
        	sb.append(cnt+"\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}