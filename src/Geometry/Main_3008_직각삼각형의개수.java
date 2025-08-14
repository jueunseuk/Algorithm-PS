package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_3008_직각삼각형의개수 {

    static class Dot {
        int x, y;
        Dot(int x, int y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Dot[] p = new Dot[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        long ans = 0;
        HashMap<Long, Integer> map = new HashMap<>(n * 2);

        for (int i = 0; i < n; i++) {
            map.clear();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                long dx = (long) p[j].x - p[i].x;
                long dy = (long) p[j].y - p[i].y;
                if (dx == 0 && dy == 0) continue;

                long g = gcd(Math.abs(dx), Math.abs(dy));
                dx /= g; dy /= g;
                if (dx < 0 || (dx == 0 && dy < 0)) { dx = -dx; dy = -dy; }

                long key = pack((int) dx, (int) dy);

                long ox = -dy, oy = dx;
                if (ox < 0 || (ox == 0 && oy < 0)) { ox = -ox; oy = -oy; }
                long okey = pack((int) ox, (int) oy);

                ans += map.getOrDefault(okey, 0);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        System.out.println(ans);
    }

    private static long gcd(long a, long b) {
        while (b != 0) { long t = a % b; a = b; b = t; }
        return a == 0 ? 1 : a;
    }

    private static long pack(int x, int y) {
        return ((long) x << 32) ^ (y & 0xffffffffL);
    }
}
