package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18221_교수님저는취업할래요 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int size = Integer.parseInt(br.readLine());
        
        int matrix[][] = new int[size][size];
        
        int sX = 0, sY = 0;
        int pX = 0, pY = 0;
        
        StringTokenizer st;
        for(int i = 0; i < size; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < size; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        		if(matrix[i][j] == 2) {
        			sX = i;
        			sY = j;
        		} else if(matrix[i][j] == 5) {
        			pX = i;
        			pY = j;
        		}
        	}
        }
        
        double distance = Math.sqrt((pX-sX)*(pX-sX) + (pY-sY)*(pY-sY));
        
        if(distance < 5) {
        	System.out.println(0);
        	return;
        }
        
        int cnt = 0;
        int startX = Math.min(pX, sX);
        int endX = Math.max(pX, sX);
        int startY = Math.min(pY, sY);
        int endY = Math.max(pY, sY);
        
        for(int i = startX; i <= endX; i++) {
        	for(int j = startY; j <= endY; j++) {
        		if(matrix[i][j] == 1) {
        			cnt++;
        		}
        	}
        }
        
        System.out.println(cnt >= 3 ? 1 : 0);
	}
}