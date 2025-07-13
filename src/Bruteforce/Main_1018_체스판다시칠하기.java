package Bruteforce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {
	
	static char board[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		board = new char[x][y];
		
		for(int i = 0; i < x; i++) {
				board[i] = br.readLine().toCharArray(); 
		}
		
		int minCnt = Integer.MAX_VALUE;
		
		for(int i = 0; i <= x-8; i++) {
			for(int j = 0; j <= y-8; j++) {
				minCnt = Math.min(check(i, j), minCnt);
			}
		}
		
		
		System.out.println(minCnt);
	}

	private static int check(int sX, int sY) {
		int cntW = 0;
		int cntB = 0;
		
		for(int i = sX; i < sX+8; i++) {
			for(int j = sY; j < sY+8; j++) {
				if((i+j) % 2 == 0) {
					if(board[i][j] != 'W') cntW++;
					if(board[i][j] != 'B') cntB++;
				} else {
					if(board[i][j] != 'W') cntB++;
					if(board[i][j] != 'B') cntW++;
				}
			}
		}
		
		return Math.min(cntW, cntB);
	}

}
