package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	static int row, col;
	static int[][] matrix;
	
	static final int dx[] = {-1, 0, 1, 0};
	static final int dy[] = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int sd = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        Robot robot = new Robot(sx, sy, sd);
        
        int cnt = 0;
        while(true) {
        	if(matrix[robot.x][robot.y] == 0) {
        		cnt++;
        		matrix[robot.x][robot.y]--;
        	}
        	
        	if(roundCheck(robot.x, robot.y)) { // 존재
        		for(int i = 1; i <= 4; i++) {
        			int nd = robot.d-i;
        			if(nd < 0) nd += 4;
        			int nx = robot.x + dx[nd];
        			int ny = robot.y + dy[nd];
        			
        			if(rangeCheck(nx, ny) && matrix[nx][ny] == 0) {
        				robot.x = nx;
        				robot.y = ny;
        				robot.d = nd;
        				break;
        			}
        		}
        	} else { // 존재하지 않음
        		int[] back = getBack(robot);
        		
        		if(back == null) { // 뒤가 막혔다면
        			break;
        		} else {
        			robot.x = back[0];
        			robot.y = back[1];
        		}
        	}
        }
        
        System.out.println(cnt);
	}

	private static boolean roundCheck(int x, int y) {
		for(int delta = 0; delta < 4; delta++) {
			int nx = x + dx[delta];
			int ny = y + dy[delta];
			
			if(rangeCheck(nx, ny) && matrix[nx][ny] == 0) {
				return true;
			}
		}
		
		return false;
	}

	private static boolean rangeCheck(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < row && ny < col;
	}
	
	private static int[] getBack(Robot robot) {
		int nd = (robot.d+2) % 4;
		int nx = robot.x + dx[nd];
		int ny = robot.y + dy[nd];
		
		if(rangeCheck(nx, ny) && matrix[nx][ny] <= 0) {
			return new int[] {nx, ny};
		} else {
			return null;
		}
	}

	public static class Robot {
		int x, y, d;

		public Robot(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}