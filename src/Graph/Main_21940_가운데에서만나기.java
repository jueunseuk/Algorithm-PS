package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_21940_가운데에서만나기 {
	static final int INF = 10000;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int result[][] = new int[size+1][size+1];
        for(int i = 0; i <= size; i++) {
        	Arrays.fill(result[i], INF);
        	result[i][i] = 0;
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	result[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        
        for(int k = 1; k <= size; k++) {
        	for(int i = 1; i <= size; i++) {
        		for(int j = 1; j <= size; j++) {
        			result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
        		}
        	}
        }
        
        int f = Integer.parseInt(br.readLine());
        int[] list = new int[f];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < f; i++) {
        	list[i] = Integer.parseInt(st.nextToken());
        }
        
        int min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= size; i++) {
        	int max = 0;
        	
        	for(int j = 0; j < f; j++) {
        		max = Math.max(max, result[i][list[j]] + result[list[j]][i]);
        	}
        	
        	if(max < min) {
        		min = max;
        		sb = new StringBuilder(i+" ");
        	} else if(max == min) {
        		sb.append(i+" ");
        	}
        }
        
        System.out.println(sb.toString().trim());
	}
}