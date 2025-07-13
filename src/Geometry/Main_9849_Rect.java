package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9849_Rect {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); 
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        
        if(n == 1) {
        	System.out.println((x2-x1)*(y2-y1));
        	return;
        }
        
        int maxX = x2;
        int minX = x1;
        int maxY = y2;
        int minY = y1;
        
        for(int i = 0; i < n-1; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	x1 = Integer.parseInt(st.nextToken());
        	x2 = Integer.parseInt(st.nextToken());
        	y1 = Integer.parseInt(st.nextToken());
        	y2 = Integer.parseInt(st.nextToken());
        	
        	if(x2 <= minX || x1 >= maxX || y2 <= minY || y1 >= maxY) {
        		System.out.println(0);
        		return;
        	}
        	
        	if(x1 >= minX && x2 <= maxX) {
        		minX = x1;
        		maxX = x2;
        	} else if(x1 >= minX) {
        		minX = x1;
        	} else if(x2 <= maxX) {
        		maxX= x2;
        	}
        	
        	if(y1 >= minY && y2 <= maxY) {
        		minY = y1;
        		maxY = y2;
        	} else if(y1 >= minY) {
        		minY= y1;
        	} else if(y2 <= maxY) {
        		maxY = y2;
        	}
        }
        
        System.out.println((maxX-minX)*(maxY-minY));
        
	}

}
