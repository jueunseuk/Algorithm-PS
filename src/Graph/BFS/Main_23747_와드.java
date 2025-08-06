package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23747_와드 {
	static int row, col;
    static char[][] matrix;
    static char[] move;
    static boolean[][] result;
    
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col];
        result = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
        	matrix[i] = br.readLine().toCharArray();
        }
        
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        
        move = br.readLine().toCharArray();
        for(char order : move) {
        	switch(order) {
	        	case 'W' : {
	        		expand(x, y);
	        		break;
	        	}
	        	case 'U' : {
	        		x--;
	        		break;
	        	}
	        	case 'D' : {
	        		x++;
	        		break;
	        	}
	        	case 'L' : {
	        		y--;
	        		break;
	        	}
	        	case 'R' : {
	        		y++;
	        		break;
	        	}
        	}
        }
        
        result[x][y] = true;
        for(int delta = 0; delta < 4; delta++) {
        	int nx = x + dx[delta];
        	int ny = y + dy[delta];
        	
        	if(rangeCheck(nx, ny)) {
        		result[nx][ny] = true;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(result[i][j]) {
        			sb.append('.');
        		} else {
        			sb.append('#');
        		}
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void expand(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {x, y});
		result[x][y] = true;
		
		char target = matrix[x][y];
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(rangeCheck(nx, ny) && !result[nx][ny] && matrix[nx][ny] == target) {
					q.offer(new int[] {nx, ny});
					result[nx][ny] = true;
				}
			}
		}
	}

	private static boolean rangeCheck(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < row && ny < col;
	}
}