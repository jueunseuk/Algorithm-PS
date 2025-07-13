package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2022_사다리 {
    static double x, y, c;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	x = Double.parseDouble(st.nextToken());
    	y = Double.parseDouble(st.nextToken());
    	c = Double.parseDouble(st.nextToken());

        double left = 0.0;
        double right = Math.min(x, y);

        for (int i = 0; i < 100; i++) {
            double mid = (left + right) / 2.0;
            double height = getHeight(mid);

            if (height >= c) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.printf("%.3f\n", left);
    }

    private static double getHeight(double w) {
        double a = Math.sqrt(x*x - w*w);
        double b = Math.sqrt(y*y - w*w);
        
        return (a * b) / (a + b);
    }
}
