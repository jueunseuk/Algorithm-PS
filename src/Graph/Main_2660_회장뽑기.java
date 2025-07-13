package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2660_회장뽑기 {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int [][]result = new int[n+1][n+1];
        int []candi = new int[n+1];
        
        for(int i = 1; i <= n; i++) {
        	Arrays.fill(result[i], 100);
        	result[i][i] = 0;
        }
        
        StringTokenizer st;
        while(true) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	if(start == -1 && end == -1) break;
        	
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
        
        for(int i = 1; i <= n; i++) {
        	int temp = 0;
        	for(int j = 1; j <= n; j++) {
        		if(temp < result[i][j]) {
        			temp = result[i][j];
        		}
    		}
        	
        	candi[i] = temp;
    	}
        
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        StringBuilder list = new StringBuilder();;
        for(int i = 1; i <= n; i++) {
        	if(candi[i] < min) {
        		list = new StringBuilder(i+" ");
        		cnt = 1;
        		min = candi[i];
        	} else if(candi[i] == min) {
        		cnt++;
        		list.append(i+" ");
        	}
        }
        
        System.out.println(min+" "+cnt);
        System.out.println(list.toString().trim());
    }
}