package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_33632_2교시체육 {
	static final double ZERO = 0.00000000;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double w = Double.parseDouble(st.nextToken());
        double h = Double.parseDouble(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());
        
        if(y1 > y) {
        	System.out.println(ZERO);
        	return;
        }
        
        if(y1 == 0) {
        	System.out.println((x2-x1)/w);
        	return;
        }
        
        double multi = y/(y-y1);
        
        double rex1 = x+(x1-x)*multi;
        double rex2 = x+(x2-x)*multi;
        
        if(rex1 >= w) {
        	System.out.println(ZERO);
        } else if(rex2 <= 0) {
        	System.out.println(ZERO);
        } else {
        	double length = Math.min(w, rex2)-Math.max(rex1, 0);
        	System.out.printf("%.8f", length/w);
        }
	}

}
