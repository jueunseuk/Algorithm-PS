package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main_11559_PuyoPuyo {
	static int chain = 0;
	static final int row = 12, col = 6;
	static char[][] matrix = new char[row][col];
	static boolean[][] visit;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static Deque<Character> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 0; i < row; i++) {
        	matrix[i] = br.readLine().toCharArray();
        }

        while(true) {
        	visit = new boolean[row][col];
        	boolean isPop = false;
        	Deque<int[]> tempList = new ArrayDeque<>();
        	
        	for(int i = row-1; i >= 0; i--) {
        		for(int j = 0; j < col; j++) {
        			if(!visit[i][j] && matrix[i][j] != '.') {
        				Deque<int[]> list = bfs(i, j, matrix[i][j]); 
        				if(list.size() >= 4) {
        					isPop = true;
        					tempList.addAll(list);
        				}
        			}
        		}
        	}
        	
        	if(isPop) {
				mark(tempList);
				drop();
				chain++;
			} else {
				System.out.println(chain);
				return;
			}
        }
	}
	
	private static void mark(Deque<int[]> list) {
		for(int[] out : list) {
			matrix[out[0]][out[1]] = '.';
		}
	}

	public static void drop() {
		for(int k = 0; k < col; k++) {
			q.clear();
			for(int i = row-1; i >= 0; i--) {
				if(matrix[i][k] != '.') {
					q.offerLast(matrix[i][k]);
				}
			}
			
			for(int i = row-1; i >= 0; i--) {
				if(!q.isEmpty()) {
					matrix[i][k] = q.pollFirst();
				} else {
					matrix[i][k] = '.';
				}
			}
		}
	}
	
	public static Deque<int[]> bfs(int i, int j, char c) {
		Queue<int[]> queue = new ArrayDeque<>();
		Deque<int[]> tempList = new ArrayDeque<>();
		int cnt = 1;
		
		queue.offer(new int[] {i, j});
		tempList.offerLast(new int[] {i, j});
		visit[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] == c) {
					visit[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
					tempList.offerLast(new int[] {nx, ny});
					cnt++;
				}
			}
		}
		
		if(cnt >= 4) {
			return tempList;
		}
		
		return new ArrayDeque<>();
	}
}
