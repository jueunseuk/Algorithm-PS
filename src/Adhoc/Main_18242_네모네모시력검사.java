package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18242_네모네모시력검사 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		int cntx[] = new int[row];
		int cnty[] = new int[col];
		
		char[][] matrix = new char[row][col];
		for(int i = 0; i < row; i++) {
			matrix[i] = br.readLine().toCharArray();
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] == '#') {
					cntx[i]++;
					cnty[j]++;
				}
			}
		}
		
		int x1 = -1, x2 = -1;
		for(int i = 0; i < row; i++) {
			if(cntx[i] != 0 && cntx[i] != 2) {
				if(x1 == -1) {
					x1 = cntx[i];
				} else {
					x2 = cntx[i];
				}
			}
		}
		
		if(x1 != x2) {
			if(x1 > x2) {
				System.out.println("DOWN");
			} else {
				System.out.println("UP");
			}
			return;
		}
		
		int y1 = -1, y2 = -1;
		for(int i = 0; i < col; i++) {
			if(cnty[i] != 0 && cnty[i] != 2) {
				if(y1 == -1) {
					y1 = cnty[i];
				} else {
					y2 = cnty[i];
				}
			}
		}
		
		if(y1 > y2) {
			System.out.println("RIGHT");
		} else {
			System.out.println("LEFT");
		}
	}
}