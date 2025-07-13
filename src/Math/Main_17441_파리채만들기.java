package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17441_파리채만들기 {

    private static class Point {
        double x, y;
        Point(double x, double y) { this.x = x; this.y = y; }
    }

    private static double cross(Point A, Point B, Point C) {
        return A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Point[] pts = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            pts[i] = new Point(x, y);
        }

        double area = 0;
        for (int i = 0; i < N - 1; i++)
            area += cross(pts[0], pts[i], pts[i + 1]) / 2.0;

        double val1 = 0, val2 = 0, val3 = 0;
        for (int i = 0; i < N; i++) {
            Point p  = pts[i];
            Point p1 = pts[(i + 1) % N];

            double xi  = p.x,  xi1  = p1.x;
            double yi  = p.y,  yi1  = p1.y;

            val1 += ((yi1 - yi) * (xi*xi*xi + xi*xi*xi1 + xi*xi1*xi1 + xi1*xi1*xi1)
                    - (xi1 - xi) * (yi*yi*yi + yi*yi*yi1 + yi*yi1*yi1 + yi1*yi1*yi1)) / 12.0;

            val2 += (yi1 - yi) * (xi*xi + xi*xi1 + xi1*xi1) / 6.0;
            val3 += (xi1 - xi) * (yi*yi + yi*yi1 + yi1*yi1) / 6.0;
        }

        double ans = 2.0 / (area * area) * (area * val1 - val2 * val2 - val3 * val3);
        System.out.printf("%.10f%n", ans);
    }
}
