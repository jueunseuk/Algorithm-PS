package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16931_겉넓이구하기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        
        int matrix[][] = new int[row][col];
        
        int sum = 0;
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
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
        
        System.out.println(sum);
	}

}
