package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2423_전구를켜라 {
	static final int INF = 1000000000;
	
	static int row, col;
	static char[][] circuit;
	static int[][] cost;
	
	static final int dx[] = {1, -1, -1, 1};
	static final int dy[] = {1, -1, 1, -1};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        circuit = new char[row][col];
        for(int i = 0; i < row; i++) {
        		circuit[i] = br.readLine().toCharArray();
        }
        
        if ((row + col) % 2 == 1) {
            System.out.println("NO SOLUTION");
            return;
        }
        
        bfs(0, 0	);
	}

	private static void bfs(int i, int j) {
		Deque<int[]> dq = new ArrayDeque<>();
		cost = new int[row+1][col+1];
		for(int a = 0; a <= row; a++) Arrays.fill(cost[a], INF);
		
		dq.offer(new int[] {i, j, 0});
		cost[i][j] = 0;
		
		while(!dq.isEmpty()) {
			int[] poll = dq.pollFirst();
			
			if(poll[0] == row && poll[1] == col) {
				System.out.println(poll[2]);
				return;
			}
			
			int nx = poll[0] + 1;
			int ny = poll[1] + 1;
			if(!outOfRange(nx, ny) && cost[nx][ny] > poll[2]) {
				if(circuit[poll[0]][poll[1]] == '\\') {
					dq.offerFirst(new int[] {nx, ny, poll[2]});
					cost[nx][ny] = poll[2];
				} else {
					if(cost[nx][ny] > poll[2]+1) {
						dq.offerLast(new int[] {nx, ny, poll[2] + 1});
						cost[nx][ny] = poll[2] + 1;
					}
				}
			}
			
			nx = poll[0] - 1;
			ny = poll[1] - 1;
			if(!outOfRange(nx, ny) && cost[nx][ny] > poll[2]) {
				if(circuit[nx][ny] == '\\') {
					dq.offerFirst(new int[] {nx, ny, poll[2]});
					cost[nx][ny] = poll[2];
				} else {
					if(cost[nx][ny] > poll[2]+1) {
						dq.offerLast(new int[] {nx, ny, poll[2] + 1});
						cost[nx][ny] = poll[2] + 1;
					}
				}
			}
			
			nx = poll[0] + 1;
			ny = poll[1] - 1;
			if(!outOfRange(nx, ny) && cost[nx][ny] > poll[2]) {
				if(circuit[poll[0]][ny] == '/') {
					dq.offerFirst(new int[] {nx, ny, poll[2]});
					cost[nx][ny] = poll[2];
				} else {
					if(cost[nx][ny] > poll[2]+1) {
						dq.offerLast(new int[] {nx, ny, poll[2] + 1});
						cost[nx][ny] = poll[2] + 1;
					}
				}
			}
			
			nx = poll[0] - 1;
			ny = poll[1] + 1;
			if(!outOfRange(nx, ny) && cost[nx][ny] > poll[2]) {
				if(circuit[nx][poll[1]] == '/') {
					dq.offerFirst(new int[] {nx, ny, poll[2]});
					cost[nx][ny] = poll[2];
				} else {
					if(cost[nx][ny] > poll[2]+1) {
						dq.offerLast(new int[] {nx, ny, poll[2] + 1});
						cost[nx][ny] = poll[2] + 1;
					}
				}
			}
		}
		
		System.out.println("NO SOLUTION");
	}

	private static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx > row || ny > col;
	}
}