package Graph.FloydWarshall;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int size = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int [][]result = new int[size][size];
        
        for(int i = 0; i < size; i++) {
        	Arrays.fill(result[i], 1000000000);
        	result[i][i] = 0;
        }
        
        StringTokenizer st;
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken())-1;
        	int end = Integer.parseInt(st.nextToken())-1;
        	int cost = Integer.parseInt(st.nextToken());
        	
        	result[start][end] = Math.min(result[start][end], cost);
        }
        
        for(int k = 0; k < size; k++) {
        	for(int i = 0; i < size; i++) {
        		for(int j = 0; j < size; j++) {
    				result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int[] arr : result) {
        	for(int out : arr) {
        		if(out == 1000000000) {
        			sb.append(0+" ");
        		} else {
        			sb.append(out+" ");
        		}
        	}
        	sb.deleteCharAt(sb.length()-1).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}