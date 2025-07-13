package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17247 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][]board = new int[N][M];
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==1) {
					list.add(i);
					list.add(j);
				}
			}
		}
		
		int distance = 0;
		
		distance += Math.abs(list.get(2) - list.get(0)) + Math.abs(list.get(3) - list.get(1));
		
		System.out.println(distance);
		
	}

}
