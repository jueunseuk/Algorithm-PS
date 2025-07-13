package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25711_인경산 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        int m[][] = new int[n][2];
        StringTokenizer x = new StringTokenizer(br.readLine(), " ");
        StringTokenizer y = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	m[i][0] = Integer.parseInt(x.nextToken());
        	m[i][1] = Integer.parseInt(y.nextToken());
        }

        double right[] = new double[n];
        double left[] = new double[n];
        right[0] = 0;
        
        for(int i = 1; i < n; i++) {
        	if(m[i][1] > m[i-1][1]) {
        		double calc = calc(m[i][0]-m[i-1][0], m[i][1]-m[i-1][1]);
        		right[i] = right[i-1] + 3*calc;
        	} else if(m[i][1] == m[i-1][1]) {
        		right[i]= right[i-1] + 2*(m[i][0] - m[i-1][0]);
        	} else {
        		double calc = calc(m[i][0]-m[i-1][0], m[i-1][1]-m[i][1]);
        		right[i] = right[i-1] + calc;
        	}
        }
        
        left[n-1] = 0;
        for(int i = n-2; i >= 0; i--) {
        	if(m[i][1] > m[i+1][1]) {
        		double calc = calc(m[i][0]-m[i+1][0], m[i][1]-m[i+1][1]);
        		left[i] = left[i+1] + 3*calc;
        	} else if(m[i][1] == m[i+1][1]) {
        		left[i] = left[i+1] + 2*(m[i+1][0] - m[i][0]);
        	} else {
        		double calc = calc(m[i][0]-m[i+1][0], m[i+1][1]-m[i][1]);
        		left[i] = left[i+1] + calc;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken())-1;
        	int end = Integer.parseInt(st.nextToken())-1;
        	
        	if(start > end) {
        		sb.append(String.format("%.7f", left[end]-left[start]));
        	} else {
        		sb.append(String.format("%.7f", right[end]-right[start]));
        	}
        	sb.append("\n");
        }
        
        br.close();
        
        System.out.println(sb.toString().trim());
	}
	
	public static double calc(double x, double y) {
		return Math.sqrt(x*x + y*y);
	}
}