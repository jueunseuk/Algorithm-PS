package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16956_늑대와양 {
	static int row, col;
	static char[][] matrix;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new char[row][col];
		
		for(int i = 0; i < row; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] == 'W') {
					if(isSheep(i, j)) {
						System.out.println(0);
						return;
					} else {
						marking(i, j);
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(1+"\n");
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				sb.append(matrix[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}

	private static void marking(int i, int j) {
		for(int delta = 0; delta < 4; delta++) {
			int nx = i + dx[delta];
			int ny = j + dy[delta];
			
			if(rangeCheck(nx, ny) && matrix[nx][ny] == '.') {
				matrix[nx][ny] = 'D';
			}
		}
	}

	private static boolean isSheep(int i, int j) {
		for(int delta = 0; delta < 4; delta++) {
			int nx = i + dx[delta];
			int ny = j + dy[delta];
			
			if(rangeCheck(nx, ny) && matrix[nx][ny] == 'S') {
				return true;
			}
		}
		return false;
	}

	private static boolean rangeCheck(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < row && ny < col;
	}
}