package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9455_박스 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int row = Integer.parseInt(st.nextToken());
        	int col = Integer.parseInt(st.nextToken());
        	
        	int[][] matrix = new int[row][col];
        	for(int i = 0; i < row; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for(int j = 0; j < col; j++) {
        			matrix[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	int sum = 0;
        	for(int j = 0; j < col; j++) {
        		int cnt = 0;
        		for(int i = row-1; i >= 0; i--) {
        			if(matrix[i][j] == 1) {
        				cnt++;
        				sum += row-i-cnt;
        			}
        		}
        	}
        	
        	sb.append(sum).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}