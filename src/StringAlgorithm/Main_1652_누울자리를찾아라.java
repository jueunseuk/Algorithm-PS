package StringAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1652_누울자리를찾아라 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		char[][] matrix = new char[size][size];
		for(int i = 0; i < size; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		int row = 0, col = 0;
		
		for(int i = 0; i < size; i++) {
			StringBuilder sbr = new StringBuilder();
			StringBuilder sbc = new StringBuilder();
			for(int j = 0; j < size; j++) {
				sbr.append(matrix[i][j]);
			}
			for(int j = 0; j < size; j++) {
				sbc.append(matrix[j][i]);
			}
			
			String[] sbrr = sbr.toString().split("X");
			for(String out : sbrr) {
				if(out.length() > 1) row++;
			}
			
			String[] sbcc = sbc.toString().split("X");
			for(String out : sbcc) {
				if(out.length() > 1) col++;
			}
		}
		
		System.out.println(row+" "+col);
	}
}