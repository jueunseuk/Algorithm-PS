package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	static int row, col, cnt = 1;
	static int matrix[][];
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        // 0 : 북, 1 : 동, 2 : 남, 3 : 서 => 회전은 항상 반시계 = 즉, 감소
        st = new StringTokenizer(br.readLine(), " ");
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int startD = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        matrix[startX][startY] = 2;
        
        int cx = startX, cy = startY, cd = startD;
        while(true) {
        	if(matrix[cx+dx[cd]][cy+dy[cd]] == 0) {
        		cx += dx[cd];
        		cy += dy[cd];
        		matrix[cx][cy] = 0;
        		cnt++;
        		continue;
        	} else {
        		if(cd > 0) cd--;
        		else cd = 3;
        	}
        	
        	
        	
        }
        
	}

}
