package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_31534_현대모비스선풍기굴리기 {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double h = Double.parseDouble(st.nextToken());
        
        if(a == 0) {
        	double result = (h*h+b*b)*Math.PI;
        	System.out.println(result);
        } else if(a == b) {
        	System.out.println(-1);
        } else {
        	double x1 = a*h/(b-a);
        	double slope1 = x1*x1+a*a;
        	double x2 = x1+h;
        	double slope2 = b*b+x2*x2;
        	double result = (slope2-slope1)*Math.PI;
        	System.out.println(result < 0 ? -result : result);
        }
	}
}