package Graph.FloydWarshall;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int [][] result = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
        	Arrays.fill(result[i], 10000);
        	result[i][i] = 0;
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	result[start][end] = 1;
        	result[end][start] = 1;
        }
        
        for(int k = 1; k <= n; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
        			result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
        		}
        	}
        }
        
        int min = Integer.MAX_VALUE;
        int num = 0;
        for(int i = 1; i <= n; i++) {
        	int temp = 0;
        	for(int j = 1; j <= n; j++) {
        		if(i != j) {
        			temp += result[i][j];
        		}
        	}
        	
        	if(min > temp) {
        		min = temp;
        		num = i;
        	}
        }
        
        System.out.println(num);
	}
}