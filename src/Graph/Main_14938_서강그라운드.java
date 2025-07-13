package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14938_서강그라운드 {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int []item = new int[n+1];
        int [][] result = new int[n+1][n+1];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) {
        	item[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i <= n; i++) {
        	Arrays.fill(result[i], 10000);
        	result[i][i] = 0;
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	
        	result[start][end] = cost;
        	result[end][start] = cost;
        }
        
        for(int k = 1; k <= n; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
        			result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
        		}
        	}
        }
        
        int max = 0;
        for(int i = 1; i <= n; i++) {
        	int temp = 0;
        	for(int j = 1; j <= n; j++) {
        		if(result[i][j] < range) {
        			temp += item[j];
        		}
        	}
        	
        	if(max < temp) {
        		max = temp;
        	}
        }
        
        System.out.println(max);
	}
}