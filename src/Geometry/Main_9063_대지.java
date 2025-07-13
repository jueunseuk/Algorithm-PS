package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9063_대지 {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        int x, y;
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());
        	
        	if(minX > x) {
        		minX = x;
        	}
        	if(maxX < x) {
        		maxX = x;
        	}
        	if(minY > y) {
        		minY = y;
        	}
        	if(maxY < y) {
        		maxY = y;
        	}
        }
        
        System.out.println((maxX-minX)*(maxY-minY));
	}
}
