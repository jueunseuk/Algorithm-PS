package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_1941_소문난칠공주 {
	static int cnt = 0;
	static char[][] matrix;
	static boolean[][] visit;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        matrix = new char[5][5];
        
        for(int i = 0; i < 5; i++) {
        	matrix[i] = br.readLine().toCharArray();
        }
        
        for(int i = 0; i < 5; i++) {
        	for(int j = 0; j < 5; j++) {
        		bfs(i, j);
        	}
        }
        
	}

	private static void bfs(int i, int j) {
		visit = new boolean[5][5];
		
		Queue<int[]> q = new ArrayDeque<>();
		
		if(matrix[i][j] == 'S') {
			// i n j n som n yeon
			q.offer(new int[] {i, j, 1, 0});
		} else {
			q.offer(new int[] {i, j, 0, 1});
		}
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[2]+poll[3] == 7 && poll[2] > 3) {
				cnt++;
				continue;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
			}
		}
		
	}

}
