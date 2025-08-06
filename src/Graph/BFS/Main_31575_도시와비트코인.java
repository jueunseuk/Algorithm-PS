package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_31575_도시와비트코인 {
	static int matrix[][];
	static int row, col;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        bfs(0, 0);
        
        System.out.println(matrix[row-1][col-1] == 2 ? "Yes" : "No");

	}

	private static void bfs(int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		matrix[x][y]++;
		
		while(!q.isEmpty()) {
			int []arr = q.poll();
			
			if(arr[0]+1 < row && matrix[arr[0]+1][arr[1]] == 1) {
				q.add(new int[] {arr[0]+1, arr[1]});
				matrix[arr[0]+1][arr[1]] = 2;
			}
			if(arr[1]+1 < col && matrix[arr[0]][arr[1]+1] == 1) {
				q.add(new int[] {arr[0], arr[1]+1});
				matrix[arr[0]][arr[1]+1] = 2;
			}
		}
		
	}

}
