package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_2667 {
	
	static boolean[][] isVisited;
	static int[][] map;
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static int N,  cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		isVisited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		List<Integer> danjiSizes = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !isVisited[i][j]) {
					cnt = 0; // 단지의 크기를 세기 위해 cnt 초기화
					bfs(i, j);
					danjiSizes.add(cnt); // 단지의 크기를 리스트에 추가
				}
			}
		}
		
		Collections.sort(danjiSizes);
		
		System.out.println(danjiSizes.size());
		for(int size : danjiSizes) {
			System.out.println(size);
		}
		
		br.close();
	}//main
	
	public static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row, col});
		
		isVisited[row][col] = true;
		cnt++;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0];
			int y = pos[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if(map[nx][ny] == 1 && !isVisited[nx][ny]) {
						queue.add(new int[] {nx, ny});
						isVisited[nx][ny] = true;
						cnt++;
					}
				}
			}
		}
		
	}//bfs
}//class