package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20149_선분교차3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());

        int ccw1 = CCW(x1, y1, x2, y2, x3, y3) * CCW(x1, y1, x2, y2, x4, y4);
        int ccw2 = CCW(x3, y3, x4, y4, x1, y1) * CCW(x3, y3, x4, y4, x2, y2);

        boolean isIntersect = false;
        if (ccw1 == 0 && ccw2 == 0) {
            if (isOverlap(x1, x2, x3, x4) && isOverlap(y1, y2, y3, y4)) {
                isIntersect = true;
            }
        } else if (ccw1 <= 0 && ccw2 <= 0) {
            isIntersect = true;
        }

        if (!isIntersect) {
            System.out.println(0);
        } else {
            System.out.println(1);
            double D = (x2 - x1) * (y4 - y3) - (y2 - y1) * (x4 - x3);

            if (D == 0) {
                double xStart = Math.max(Math.min(x1, x2), Math.min(x3, x4));
                double xEnd = Math.min(Math.max(x1, x2), Math.max(x3, x4));
                double yStart = Math.max(Math.min(y1, y2), Math.min(y3, y4));
                double yEnd = Math.min(Math.max(y1, y2), Math.max(y3, y4));

                double eps = 1e-15;
                
                boolean xSinglePoint = Math.abs(xEnd - xStart) < eps; 
                boolean ySinglePoint = Math.abs(yEnd - yStart) < eps;
                
                if (xSinglePoint && ySinglePoint) {
                    double interX = xStart;
                    double interY = yStart;
                    printCoordinate(interX, interY);
                }
            } else {
                double t = ((x3 - x1) * (y4 - y3) - (y3 - y1) * (x4 - x3)) / D;
                double interX = x1 + t * (x2 - x1);
                double interY = y1 + t * (y2 - y1);

                printCoordinate(interX, interY);
            }
        }
    }

    public static int CCW(long x1, long y1, long x2, long y2, long x3, long y3) {
        long result = x1 * y2 + x2 * y3 + x3 * y1 - (y1 * x2 + y2 * x3 + y3 * x1);
        if (result > 0) return 1;
        if (result < 0) return -1;
        return 0;
    }

    public static boolean isOverlap(long a1, long a2, long b1, long b2) {
        return Math.max(Math.min(a1, a2), Math.min(b1, b2)) <= Math.min(Math.max(a1, a2), Math.max(b1, b2));
    }

    public static void printCoordinate(double x, double y) {
        if (Math.abs(x - Math.round(x)) < 1e-9) {
            System.out.print((long)Math.round(x) + " ");
        } else {
            System.out.printf("%.9f ", x);
        }

        if (Math.abs(y - Math.round(y)) < 1e-9) {
            System.out.print((long)Math.round(y));
        } else {
            System.out.printf("%.9f", y);
        }
        System.out.println();
    }
}
