package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main_17025_Icy {
	static int size, resultArea = 0, resultLength = Integer.MAX_VALUE;
	static char matrix[][];
	static boolean visit[][];
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        
        matrix = new char[size+2][size+2];
        visit = new boolean[size+2][size+2];
        
        for(int i = 0; i < size+2; i++) {
        	Arrays.fill(matrix[i], '.');
        }
        
        for(int i = 1; i <= size; i++) {
        	char input[] = br.readLine().toCharArray();
        	for(int j = 1; j <= size; j++) {
        		matrix[i][j] = input[j-1];
        	}
        }
        
        for(int i = 1; i <= size; i++) {
        	for(int j = 1; j <= size; j++) {
        		if(!visit[i][j] && matrix[i][j] == '#') {
        			bfs(i, j);
        		}
        	}
        }
        
        System.out.println(resultArea+" "+resultLength);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		
		int area = 1, length = 0;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(matrix[nx][ny] == '.') {
					length++;
				}
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 1 && ny >= 1 && nx <= size && ny <= size && !visit[nx][ny] && matrix[nx][ny] == '#') {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
					area++;
				}
			}
		}
		
		if(resultArea < area) {
			resultArea = area;
			resultLength = length;
		} else if(resultArea == area) {
			resultLength = Math.min(length, resultLength);
		}
	}

}
