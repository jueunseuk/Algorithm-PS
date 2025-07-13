package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7869_두원 {
	static final double PI = 3.14159265358979323846;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double r1 = Double.parseDouble(st.nextToken());
        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());
        double r2 = Double.parseDouble(st.nextToken());
        
        double distance = distance(x1, y1, x2, y2);
        
        // 겹침 x
        if(r1 + r2 <= distance) {
        	System.out.println("0.000");
        	return;
        }
        
        // 포함
        if(distance <= Math.abs(r1-r2)) {
        	if(r1 > r2) {
        		double area = circle(r2);
        		System.out.printf("%.3f", area);
        	} else {
        		double area = circle(r1);
        		System.out.printf("%.3f", area);
        	}
        	return;
        }

        // 겹침
        double r1Sq = r1 * r1;
        double r2Sq = r2 * r2;

        double part1 = r1Sq * Math.acos((distance*distance + r1Sq - r2Sq) / (2 * distance * r1));
        double part2 = r2Sq * Math.acos((distance*distance + r2Sq - r1Sq) / (2 * distance * r2));
        double part3 = 0.5 * Math.sqrt((-distance + r1 + r2) * (distance + r1 - r2) * (distance - r1 + r2) * (distance + r1 + r2));

        System.out.printf("%.3f", part1 + part2 - part3);
	}
	
	public static double circle(double r1) {
		return PI*r1*r1;
	}
	
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	}

}
