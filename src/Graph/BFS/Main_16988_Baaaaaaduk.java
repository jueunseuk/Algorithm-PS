package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16988_Baaaaaaduk {
	static int row, col, max = 0;
	static int matrix[][];
	static boolean visit[][];
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        		if(matrix[i][j] == 0) {
        			list.add(new int[] {i, j});
        		}
        	}
        }
        
        int size = list.size();
        for(int i = 0; i < size-1; i++) {
        	for(int j = i+1; j < size; j++) {
        		visit = new boolean[row][col];
        		
        		matrix[list.get(i)[0]][list.get(i)[1]] = 1;
        		matrix[list.get(j)[0]][list.get(j)[1]] = 1;
        		
        		int current = 0;
        		for(int k = 0; k < row; k++) {
        			for(int l = 0; l < col; l++) {
        				if(!visit[k][l] && matrix[k][l] == 2) {
        					current += bfs(k, l);
        				}
        			}
        		}
        		max = Math.max(current, max);
        		
        		matrix[list.get(i)[0]][list.get(i)[1]] = 0;
        		matrix[list.get(j)[0]][list.get(j)[1]] = 0;
        	}
        }
        
        System.out.println(max);
	}

	private static int bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		
		int cnt = 1;
		boolean find = false;
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx < 0 || ny < 0 || nx >= row || ny >= col || visit[nx][ny] || matrix[nx][ny] == 1) {
					continue;
				}
				
				if(matrix[nx][ny] == 0) {
					find = true;
				}
				
				if(matrix[nx][ny] == 2) {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
					cnt++;
				}
			}
		}
		
		return find ? 0 : cnt;
	}

}
