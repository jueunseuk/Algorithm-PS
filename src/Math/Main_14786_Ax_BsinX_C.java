package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14786_Ax_BsinX_C {
	static double a, b, c;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Double.parseDouble(st.nextToken());
        b = Double.parseDouble(st.nextToken());
        c = Double.parseDouble(st.nextToken());
        
        double left = -1e6;
        double right = 1e6;
        double epsilon = 1e-10;
        
        while(right - left > epsilon) {
        	double mid = (left+right) / 2.0;
        	
        	if(equation(mid) > 0) {
        		right = mid;
        	} else {
        		left = mid;
        	}
        }
        
        double result = (left+right)/2.0;
        
        System.out.println(result);

	}
	
	public static double equation(double x) {
		return a*x+b*Math.sin(x)-c;
	}

}
