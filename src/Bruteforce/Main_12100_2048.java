package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100_2048 {
	static int size, largest = 0;
	static int[][] matrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		
		matrix = new int[size][size];
		
		StringTokenizer st;
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < size; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		tracking(matrix, 0);
		
		System.out.println(largest);
	}

	private static void tracking(int[][] currMatrix, int depth) {
		if(depth == 5) {
			largest = Math.max(largest, getMax(currMatrix));
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int[][] newMatrix = move(currMatrix, i);
			tracking(newMatrix, depth+1);
		}
	}

	static int[][] move(int[][] src, int dir) {
	    int[][] dst = new int[size][size];

	    for (int i = 0; i < size; i++) {
	        int[] line = new int[size];
	        int idx = 0;
	        int prev = 0;

	        for (int j = 0; j < size; j++) {
	            int r = i, c = j;
	            if (dir == 0) { r = j; c = i; }
	            else if (dir == 1) { r = size - 1 - j; c = i; }
	            else if (dir == 2) { r = i; c = j; }
	            else if (dir == 3) { r = i; c = size - 1 - j; }

	            int val = src[r][c];
	            if (val == 0) continue;

	            if (prev == 0) {
	                prev = val;
	            } else {
	                if (prev == val) {
	                    line[idx++] = prev * 2;
	                    prev = 0;
	                } else {
	                    line[idx++] = prev;
	                    prev = val;
	                }
	            }
	        }
	        
	        if (prev != 0) line[idx] = prev;

	        for (int j = 0; j < size; j++) {
	            int writeVal = line[j];
	            
	            switch (dir) {
	                case 0 : {
	                	dst[j][i] = writeVal;
	                	break;
	                }
	                case 1 : {
	                	dst[size - 1 - j][i] = writeVal;
	                	break;
	                }
	                case 2 : {
	                	dst[i][j] = writeVal;
	                	break;
	                }
	                case 3 : {
	                	dst[i][size - 1 - j] = writeVal;
	                	break;
	                }
	            }
	        }
	    }
	    
	    return dst;
	}

	private static int getMax(int[][] currMatrix) {
		int large = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				large = Math.max(large, currMatrix[i][j]);
			}
		}
		
		return large;
	}
}