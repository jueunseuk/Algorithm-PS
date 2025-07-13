package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_32282_너그리고나 {
	static final double EPSILON = 1e-9;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        System.out.println(minimumJumps(x, y, c));

	}
	
	public static int minimumJumps(double X, double Y, double c) {
        double d = Math.sqrt(X * X + Y * Y);
        
        if (Math.abs(d) < EPSILON) {
            return 0;
        } else if (Math.abs(d - c) < EPSILON) {
            return 1;
        } else if (d < c) {
            return 2;
        } else {
            return (int) Math.ceil(d / c);
        }
    }

}
