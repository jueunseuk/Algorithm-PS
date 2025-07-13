package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6600_원의둘레 {
	static final double PI = 3.141592653589793;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        
        StringBuilder sb = new StringBuilder();
        while(true) {
        	String line = br.readLine();

            if(line == null || line.trim().isEmpty()) {
                break;
            }

            st = new StringTokenizer(line, " ");
        	
        	double x1 = Double.parseDouble(st.nextToken());
        	double y1 = Double.parseDouble(st.nextToken());
        	double x2 = Double.parseDouble(st.nextToken());
        	double y2 = Double.parseDouble(st.nextToken());
        	double x3 = Double.parseDouble(st.nextToken());
        	double y3 = Double.parseDouble(st.nextToken());
        	
        	double a = calc(x1, y1, x2, y2);
        	double b = calc(x1, y1, x3, y3);
        	double c = calc(x3, y3, x2, y2);
        	
        	double area = calcArea(a, b, c);
        	
        	double result = (a*b*c*PI)/2/area;
        	
        	sb.append(Math.round(result*100)/100.0).append("\n");
        }
        
        System.out.println(sb.toString().trim());

	}
	
	private static double calcArea(double a, double b, double c) {
		double s = (a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}

	public static double calc(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	}

}
