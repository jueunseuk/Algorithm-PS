package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_31716_현대모비스자율주행 {
	static final int INF = 1000000000;
	
	static int row = 2, col, col2, col3, repeat, onceResult = INF, twiceResult = INF, thriceResult = INF;
	static char[][] matrix;
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        col2 = col*2;
        col3 = col*3;
        repeat = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col3];
		visit = new boolean[row][col3];
		
		for(int i = 0; i < row; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < col; j++) {
				matrix[i][j] = input[j];
				matrix[i][col+j] = input[j];
				matrix[i][col2+j] = input[j];
			}
		}
		
		bfs();
		
        if(repeat == 1) {
        	if(onceResult == INF) {
        		System.out.println(-1);
        		return;
        	}
        	System.out.println(onceResult);
        } else if(repeat == 2) {
        	if(twiceResult == INF) {
        		System.out.println(-1);
        		return;
        	}
        	System.out.println(twiceResult);
        } else {
        	if(onceResult == INF || twiceResult == INF) {
        		System.out.println(-1);
        		return;
        	}
        	int delta1 = twiceResult  - onceResult;
            long result = (long) onceResult + (long)(repeat - 1) * delta1;
            System.out.println(result);
        }
	}

	private static void bfs() throws Exception {
		Queue<int[]> q = new ArrayDeque<>();
		
		if(matrix[0][0] == '.') {
			q.offer(new int[] {0, 0, 0});
			visit[0][0] = true;
		}
		if(matrix[1][0] == '.') {
			q.offer(new int[] {1, 0, 0});
			visit[1][0] = true;
		}
		
		int once = col-1;
		int twice = col*2-1;
		int thrice = col*3-1;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] == once) {
				onceResult = Math.min(onceResult, poll[2]);
			} else if(poll[1] == twice) {
				twiceResult = Math.min(twiceResult, poll[2]);
			} else if (poll[1] == thrice) {
				thriceResult = poll[2];
				return;
			}
			
			int nc = poll[2]+1;
			if(poll[0] == 0) {
				int nx = poll[0]+1;
				int ny = poll[1];
				if(!visit[nx][ny] && matrix[nx][ny] == '.') {
					q.offer(new int[] {nx, ny, nc});
					visit[nx][ny] = true;
				}
				
				nx--;
				ny++;
				if(ny >= col3) continue;
				if(!visit[nx][ny] && matrix[nx][ny] == '.') {
					q.offer(new int[] {nx, ny, nc});
					visit[nx][ny] = true;
				}
			} else {
				int nx = poll[0]-1;
				int ny = poll[1];
				if(!visit[nx][ny] && matrix[nx][ny] == '.') {
					q.offer(new int[] {nx, ny, nc});
					visit[nx][ny] = true;
				}
				
				nx++;
				ny++;
				if(ny >= col3) continue;
				if(!visit[nx][ny] && matrix[nx][ny] == '.') {
					q.offer(new int[] {nx, ny, nc});
					visit[nx][ny] = true;
				}
			}
		}
	}
}