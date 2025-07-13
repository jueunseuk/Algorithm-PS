package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_24726_미적분학입문하기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());
        double x3 = Double.parseDouble(st.nextToken());
        double y3 = Double.parseDouble(st.nextToken());
        
        double area = Math.abs(x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2))/2.0;
        
        double cx = (x1 + x2 + x3) / 3.0;
        double cy = (y1 + y2 + y3) / 3.0;
        
        double volX = 2.0 * Math.PI * cy * area;
        double volY = 2.0 * Math.PI * cx * area;
        
        System.out.printf("%.9f %.9f\n", volX, volY);
    }
}
