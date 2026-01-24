package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7561_크래머의공식 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int t = 0; t < T; t++) {
        	int[][] arr = new int[3][3];
        	int[] sol = new int[3];
        	
        	for(int i = 0; i < 3; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < 3; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        		sol[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	long det = getDeterminant(arr);
        	
        	int[][] arr1 = copy(arr);
        	arr1[0][0] = sol[0];
        	arr1[1][0] = sol[1];
        	arr1[2][0] = sol[2];
        	long det1 = getDeterminant(arr1);
        	
        	int[][] arr2 = copy(arr);
        	arr2[0][1] = sol[0];
        	arr2[1][1] = sol[1];
        	arr2[2][1] = sol[2];
        	long det2 = getDeterminant(arr2);
        	
        	int[][] arr3 = copy(arr);
        	arr3[0][2] = sol[0];
        	arr3[1][2] = sol[1];
        	arr3[2][2] = sol[2];
        	long det3 = getDeterminant(arr3);
        	
        	append(det1, det2, det3, det);
        }

        System.out.println(sb.toString().trim());
	}

	private static int[][] copy(int[][] arr) {
		int[][] copy = new int[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}

	private static void append(long det1, long det2, long det3, long det) {
		sb.append(det1).append(" ").append(det2).append(" ").append(det3).append(" ").append(det).append("\n");
		
		if(det == 0) {
			sb.append("No unique solution\n");
		} else {
			double x = (double) det1 / det;
			double y = (double) det2 / det;
			double z = (double) det3 / det;
			
			if(x < 0.0005 && x > -0.0005) x = 0.0;
			if(y < 0.0005 && y > -0.0005) y = 0.0;
			if(z < 0.0005 && z > -0.0005) z = 0.0;
			
			sb.append("Unique solution: ")
				.append(String.format("%.3f", x)).append(" ")
				.append(String.format("%.3f", y)).append(" ")
				.append(String.format("%.3f", z)).append("\n");
		}
		sb.append("\n");
	}

	public static long getDeterminant(int[][] arr) {
		long a = arr[0][0]*arr[1][1]*arr[2][2];
		long b = arr[0][1]*arr[1][2]*arr[2][0];
		long c = arr[1][0]*arr[2][1]*arr[0][2];
		long d = arr[0][2]*arr[1][1]*arr[2][0];
		long e = arr[0][1]*arr[1][0]*arr[2][2];
		long f = arr[1][2]*arr[2][1]*arr[0][0];
		
		return a+b+c-d-e-f;
	}
}
