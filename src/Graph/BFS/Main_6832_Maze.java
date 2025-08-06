package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_6832_Maze {
	static int row, col;
    static char[][] matrix;
    static boolean[][] visit;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static StringBuilder result = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
        	row = Integer.parseInt(br.readLine());
        	col = Integer.parseInt(br.readLine());
        	
        	matrix = new char[row][col];
        	visit = new boolean[row][col];
        	
        	for(int i = 0; i < row; i++) {
        		matrix[i] = br.readLine().toCharArray();
        	}
        	
        	bfs(0, 0);
        }
        
        System.out.println(result.toString().trim());
	}
    
    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();

        visit[i][j] = true;
        q.offer(new int[] {i, j, 1});
        
        while(!q.isEmpty()) {
        	int[] poll = q.poll();
        	
        	if(poll[0] == row-1 && poll[1] == col-1) {
        		result.append(poll[2]).append("\n");
        		return;
        	}
        	
        	int start = 0, end = 4;
        	if(matrix[poll[0]][poll[1]] == '+') {
        		start = 0;
        		end = 4;
			} else if(matrix[poll[0]][poll[1]] == '-') {
				start = 2;
				end = 4;
			} else if(matrix[poll[0]][poll[1]] == '|') {
				start = 0;
				end = 2;
			}
        	
        	for(int delta = start; delta < end; delta++) {
        		int nx = poll[0] + dx[delta];
        		int ny = poll[1] + dy[delta];
        		
        		if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] != '*') {
        			visit[nx][ny] = true;
        			q.offer(new int[] {nx, ny, poll[2]+1});
        		}
        	}
        }
        
        result.append(-1).append("\n");
    }

}
