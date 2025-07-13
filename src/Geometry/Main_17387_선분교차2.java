package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17387_선분교차2 {

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

        if (ccw1 == 0 && ccw2 == 0) {
            if (isOverlap(x1, x2, x3, x4) && isOverlap(y1, y2, y3, y4)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else if (ccw1 <= 0 && ccw2 <= 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
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
}
