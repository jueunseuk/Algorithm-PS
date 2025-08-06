package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2933_미네랄 {
	static int row, col, q;
	static int[] query;
	static char[][] matrix;
	static boolean[][] visit;
	static List<List<Integer>> list; // 열에 대한 행 위치
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new char[row][col];
		
		for(int i = 0; i < row; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		q = Integer.parseInt(br.readLine());
		query = new int[q];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < q; i++) {
			query[i] = row - Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < q; i++) {
			remove(i);
			
			bfsFloor();
			
			findException();
			
			relocate();
		}
		
		print();
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				sb.append(matrix[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}

	private static void relocate() {
		int min = row;
		for(int i = 0; i < col; i++) {
			if(list.get(i).size() == 0) continue;
			
			int head = list.get(i).get(0);
			for(int j = head + 1; j < row; j++) {
				if(matrix[j][i] == 'x') {
					min = Math.min(min, j-head-1);
				} else if(j == row - 1) {
					min = Math.min(min, j-head);
				}
			}
		}
		
		for(int i = 0; i < col; i++) {
			for(int out : list.get(i)) {
				matrix[out+min][i] = 'x';
			}
		}
	}

	private static void findException() {
		list = new ArrayList<>();
		
		for(int i = 0; i < col; i++) {
			list.add(new ArrayList<>());
		}
		
		int nRow = row-1;
		for(int i = 0; i < nRow; i++) {
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] == 'x' && !visit[i][j]) {
					list.get(j).add(i);
					matrix[i][j] = '.';
				}
			}
		}
		
		for(int i = 0; i < col; i++) {
			Collections.sort(list.get(i), Collections.reverseOrder());
		}
	}

	private static void bfsFloor() {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[row][col];
		
		for(int i = 0; i < col; i++) {
			if(matrix[row-1][i] == 'x') {
				q.offer(new int[] {row-1, i});
				visit[row-1][i] = true;
			}
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(outOfRange(nx, ny) && !visit[nx][ny] && matrix[nx][ny] == 'x') {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
			}
		}
	}

	private static boolean outOfRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < row && ny < col;
	}

	private static void remove(int i) {
		if(i % 2 == 0) {
			for(int j = 0; j < col; j++) {
				if(matrix[query[i]][j] == 'x') {
					matrix[query[i]][j] = '.';
					break;
				}
			}
		} else {
			for(int j = col-1; j >= 0; j--) {
				if(matrix[query[i]][j] == 'x') {
					matrix[query[i]][j] = '.';
					break;
				}
			}
		}
	}
}