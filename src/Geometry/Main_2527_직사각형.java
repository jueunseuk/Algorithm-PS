package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2527_직사각형 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int matrix[][];
        int sx1, sy1, ex1, ey1, sx2, sy2, ex2, ey2;
        int maxX, maxY, twoCnt = 0;
        boolean rowCheck = false, colCheck = false;
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < 4; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	sx1 = Integer.parseInt(st.nextToken());
        	sy1 = Integer.parseInt(st.nextToken());
        	ex1 = Integer.parseInt(st.nextToken());
        	ey1 = Integer.parseInt(st.nextToken());
        	sx2 = Integer.parseInt(st.nextToken());
        	sy2 = Integer.parseInt(st.nextToken());
        	ex2 = Integer.parseInt(st.nextToken());
        	ey2 = Integer.parseInt(st.nextToken());
        	
        	maxX = Math.max(ex1, ex2);
        	maxY = Math.max(ey1, ey2);
        	
        	matrix = new int[maxX][maxY];
        	
        	// 첫번째 체크
        	for(int i = sx1; i < ex1; i++) {
        		for(int j = sy1; j < ey1; j++) {
        			matrix[i][j]++;
        		}
        	}
        	
        	// 두번째 체크
        	for(int i = sx2; i < ex2; i++) {
        		for(int j = sy2; j < ey2; j++) {
        			matrix[i][j]++;
        		}
        	}
        	
        	for(int i = 0; i < maxX; i++) {
        		for(int j = 0; j < maxY; j++) {
        			System.out.print(matrix[i][j]);
        		}
        		System.out.println();
        	}
        	
        	
        }
	}
}
