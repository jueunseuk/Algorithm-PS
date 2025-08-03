package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11048_이동하기2 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        
        int matrix[][] = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 1; i < row; i++) {
        	matrix[i][0] += matrix[i-1][0];
        }
        
        for(int i = 1; i < col; i++) {
        	matrix[0][i] += matrix[0][i-1];
        }
        
        for(int i = 1; i < row; i++) {
        	for(int j = 1; j < col; j++) {
        		matrix[i][j] += Math.max(matrix[i-1][j], matrix[i][j-1]);
        	}
        }
        
        System.out.println(matrix[row-1][col-1]);
	}
}