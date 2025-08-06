package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1888_곰팡이 {
	static int row, col, cnt = 0;
	static int[][] matrix;
	static boolean[][] visit;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        	char[] input = br.readLine().toCharArray();
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = input[j] - '0';
        	}
        }
        
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[2] - o1[2];
			}
        });
        
        while(!isOne()) {
        	visit = new boolean[row][col];
        	
        	for(int i = 0; i < row; i++) {
        		for(int j = 0; j < col; j++) {
        			if(!visit[i][j] && matrix[i][j] != 0) {
        				visit[i][j] = true;
        				q.offer(new int[] {i, j, matrix[i][j]});
        			}
        		}
        	}
        	
        	while(!q.isEmpty()) {
        		int[] poll = q.poll();
        		
        		paint(poll[0], poll[1], poll[2]);
        	}
        	
        	cnt++;
        }
        
        System.out.println(cnt);
	}
	
	public static void paint(int i, int j, int k) {
		int startX = Math.max(i-k, 0);
		int endX = Math.min(i+k, row-1);
		int startY = Math.max(j-k, 0);
		int endY = Math.min(j+k, col-1);
		
	    for(int r = startX; r <= endX; r++) {
	        for(int c = startY; c <= endY; c++) {
	            if(matrix[r][c] < k) {
	                matrix[r][c] = k;
	            }
	        }
	    }
	}

	public static boolean isOne() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] tempVisit = new boolean[row][col];
		
		escape:
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] != 0) {
					q.offer(new int[] {i, j});
					tempVisit[i][j] = true;
					break escape;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !tempVisit[nx][ny] && matrix[nx][ny] != 0) {
					tempVisit[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(!tempVisit[i][j] && matrix[i][j] != 0) {
					return false;
				}
			}
		}
		
		return true;
	}

}
