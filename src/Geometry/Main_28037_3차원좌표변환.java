package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_28037_3차원좌표변환 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int typeA = Integer.parseInt(st.nextToken());
        	int typeB = Integer.parseInt(st.nextToken());
        	
        	st = new StringTokenizer(br.readLine());
        	double a = Double.parseDouble(st.nextToken());
        	double b = Double.parseDouble(st.nextToken());
        	double c = Double.parseDouble(st.nextToken());
        	
        	double x, y, z;
        	if(typeA == 1) {
        		x = a;
        		y = b;
        		z = c;
        	} else if(typeA == 2) {
    			x = a * Math.cos(b);
    			y = a * Math.sin(b);
    			z = c;
    		} else {
    			x = a * Math.sin(b) * Math.cos(c);
    			y = a * Math.sin(b) * Math.sin(c);
    			z = a * Math.cos(b);
    		}
        	
        	if(typeB == 1) {
        		append(x, y, z);
        	} else if(typeB == 2) {
        		double r = Math.sqrt(x*x + y*y);
        		double phi = (r == 0.0) ? 0.0 : normPhi(Math.atan2(y, x));
        		append(r, phi, z);
        	} else {
        		double rho = Math.sqrt(x*x+y*y+z*z);
        		if(rho == 0) {
        			append(0, 0, 0);
        		} else {
        			double cosv = z / rho;
        	        if (cosv > 1) cosv = 1;
        	        if (cosv < -1) cosv = -1;
        	        
        	        double theta = Math.acos(cosv);

        	        double r = Math.sqrt(x*x + y*y);
        	        double phi = (r == 0.0) ? 0.0 : normPhi(Math.atan2(y, x));

        	        append(rho, theta, phi);       			
        		}
        	}
        }
        
        System.out.println(sb.toString().trim());
	}
	
	static double normPhi(double phi) {
	    double twoPi = 2.0 * Math.PI;
	    phi %= twoPi;
	    if (phi < 0) phi += twoPi;
	    if (phi >= twoPi) phi -= twoPi;
	    return phi;
	}

	private static void append(double x, double y, double z) {
	    sb.append(String.format("%.8f %.8f %.8f%n", x, y, z));
	}
}