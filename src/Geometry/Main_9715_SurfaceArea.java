package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9715_SurfaceArea {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        int row, col, sum;
        int matrix[][];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine());
        	row = Integer.parseInt(st.nextToken());
        	col = Integer.parseInt(st.nextToken());
        	sum = 0;
        	
        	matrix = new int[row][col];
	        
	        for(int i = 0; i < row; i++) {
	        	char[] input = br.readLine().toCharArray();
	        	for(int j = 0; j < col; j++) {
	        		matrix[i][j] = input[j] - '0';
	        		if(matrix[i][j] != 0) {
	        			sum++;
	        		}
	        	}
	        }
	        sum *= 2;
	        
	        int current;
	        
	        // 앞
	        for(int i = 0; i < col; i++) {
	        	current = 0;
	        	for(int j = row-1; j >= 0; j--) {
	        		if(matrix[j][i] > current) {
	        			sum += matrix[j][i] - current;
	        		}
	        		current = matrix[j][i];
	        	}
	        }
	        
	        // 뒤
	        for(int i = 0; i < col; i++) {
	        	current = 0;
	        	for(int j = 0; j < row; j++) {
	        		if(matrix[j][i] > current) {
	        			sum += matrix[j][i] - current;
	        		}
	        		current = matrix[j][i];
	        	}
	        }
	        
	        // 오
	        for(int i = 0; i < row; i++) {
	        	current = 0;
	        	for(int j = 0; j < col; j++) {
	        		if(matrix[i][j] > current) {
	        			sum += matrix[i][j] - current;
	        		}
	        		current = matrix[i][j];
	        	}
	        }
	        
	        // 왼
	        for(int i = 0; i < row; i++) {
	        	current = 0;
	        	for(int j = col-1; j >= 0; j--) {
	        		if(matrix[i][j] > current) {
	        			sum += matrix[i][j] - current;
	        		}
	        		current = matrix[i][j];
	        	}
	        }
	        
	        sb.append(sum).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}