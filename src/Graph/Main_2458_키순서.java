package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2458_키순서 {
	static final int INF = 1000;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int result[][] = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
        	Arrays.fill(result[i], INF);
        	result[i][i] = 0;
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	result[start][end] = 1;
        }
        
        for(int k = 1; k <= n; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
        			result[i][j] = Math.min(result[i][j], result[i][k]+result[k][j]);
        		}
        	}
        }
        
        int cnt[] = new int[n+1];
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= n; j++) {
        		if(i == j) continue;
        		
        		if(result[i][j] != INF || result[j][i] != INF) {
        			cnt[i]++;
        		}
        	}
        }
        
        int sum = 0;
        for(int out : cnt) {
        	if(out == n-1) sum++;
        }
        
        System.out.println(sum);
	}
}