package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6439_교차 {

    static class Point {
        long x, y;
        Point(long x, long y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());

            long rx1 = Long.parseLong(st.nextToken());
            long ry1 = Long.parseLong(st.nextToken());
            long rx2 = Long.parseLong(st.nextToken());
            long ry2 = Long.parseLong(st.nextToken());

            long minX = Math.min(rx1, rx2);
            long maxX = Math.max(rx1, rx2);
            long minY = Math.min(ry1, ry2);
            long maxY = Math.max(ry1, ry2);

            Point A = new Point(x1, y1);
            Point B = new Point(x2, y2);

            if (insideOrOn(A, minX, maxX, minY, maxY) || insideOrOn(B, minX, maxX, minY, maxY)) {
                sb.append('T').append('\n');
                continue;
            }

            Point R1 = new Point(minX, minY);
            Point R2 = new Point(maxX, minY);
            Point R3 = new Point(maxX, maxY);
            Point R4 = new Point(minX, maxY);

            boolean ok =
                intersectSeg(A, B, R1, R2) ||
                intersectSeg(A, B, R2, R3) ||
                intersectSeg(A, B, R3, R4) ||
                intersectSeg(A, B, R4, R1);

            sb.append(ok ? 'T' : 'F').append('\n');
        }

        System.out.print(sb.toString());
    }

    static boolean insideOrOn(Point p, long minX, long maxX, long minY, long maxY) {
        return (minX <= p.x && p.x <= maxX && minY <= p.y && p.y <= maxY);
    }

    static int ccw(Point a, Point b, Point c) {
        long v = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (v > 0) return 1;
        if (v < 0) return -1;
        return 0;
    }

    static boolean intersectSeg(Point a, Point b, Point c, Point d) {
        int ab_c = ccw(a, b, c);
        int ab_d = ccw(a, b, d);
        int cd_a = ccw(c, d, a);
        int cd_b = ccw(c, d, b);

        long ab = (long) ab_c * ab_d;
        long cd = (long) cd_a * cd_b;

        if (ab == 0 && cd == 0) {
            return overlap1D(a.x, b.x, c.x, d.x) && overlap1D(a.y, b.y, c.y, d.y);
        }

        return ab <= 0 && cd <= 0;
    }

    static boolean overlap1D(long a, long b, long c, long d) {
        long min1 = Math.min(a, b), max1 = Math.max(a, b);
        long min2 = Math.min(c, d), max2 = Math.max(c, d);
        return Math.max(min1, min2) <= Math.min(max1, max2);
    }
}
