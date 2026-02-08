package Sweeping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_2261_가장가까운두점 {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int dist(Point a, Point b) {
        int dx = a.x - b.x;
        int dy = a.y - b.y;
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Point[] points = new Point[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i] = new Point(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );
        }

        Arrays.sort(points, (a, b) -> {
            if (a.x == b.x) return a.y - b.y;
            return a.x - b.x;
        });

        TreeSet<Point> active = new TreeSet<>((a, b) -> {
            if (a.y == b.y) return a.x - b.x;
            return a.y - b.y;
        });

        int minDist = dist(points[0], points[1]);

        active.add(points[0]);
        active.add(points[1]);

        int left = 0;
        for(int i = 2; i < n; i++) {
            Point current = points[i];

            while(left < i) {
                Point p = points[left];
                int dx = current.x - p.x;

                if(dx * dx > minDist) {
                    active.remove(p);
                    left++;
                } else {
                    break;
                }
            }

            int range = (int) Math.sqrt(minDist);

            Point lower = new Point(-100000, current.y - range);
            Point upper = new Point(100000, current.y + range);

            for(Point p : active.subSet(lower, upper)) {
                int d = dist(current, p);
                if(d < minDist) {
                    minDist = d;
                }
            }

            active.add(current);
        }

        System.out.println(minDist);
    }
}