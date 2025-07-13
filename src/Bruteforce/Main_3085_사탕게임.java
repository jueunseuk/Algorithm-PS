package Bruteforce;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3085_사탕게임 {
	static int N;
	static char board[][];
	static int max = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		
		for(int i = 0 ; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i+1 < N) { // 왼쪽과 스왑
					swap(i, j, i+1, j);
					findMax();
					swap(i+1, j, i, j);
				}
				if(j+1 < N) { // 오른쪽과 스왑
					swap(i, j, i, j+1);
					findMax();
					swap(i, j+1, i, j);
				}
			}
		}
		
		System.out.println(max);
		br.close();
	}

	private static void findMax() {
		int tempMax = 1;
		
		for(int i = 0; i < N ; i++) {
			int count = 1;
			for(int j = 1; j < N; j++) {
				if(board[i][j] == board[i][j-1]) {
					count++;
				} else {
					tempMax = Math.max(tempMax, count);
					count = 1;
				}
			}
			tempMax = Math.max(tempMax, count);
		}
		for(int j = 0; j < N ; j++) {
			int count = 1;
			for(int i = 1; i < N; i++) {
				if(board[i][j] == board[i-1][j]) {
					count++;
				} else {
					tempMax = Math.max(tempMax, count);
					count = 1;
				}
			}
			tempMax = Math.max(tempMax, count);
		}
		
		max = Math.max(max, tempMax);
	}

	private static void swap(int i1, int j1, int i2, int j2) {
		char temp = board[i1][j1];
		board[i1][j1] = board[i2][j2];
		board[i2][j2] = temp;
	}

}
