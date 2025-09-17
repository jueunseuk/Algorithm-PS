package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_15028_비스킷부수기 {
	static Point standard;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        List<Point> point = new ArrayList<>();
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	point.add(new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }
        
        standard = Collections.min(point, (a, b) -> {
            if (a.y != b.y) return Long.compare(a.y, b.y);
            return Long.compare(a.x, b.x);
        });
        
        point.remove(standard);
        
        for(Point out : point) {
        	out.angle = Math.atan2(out.y-standard.y, out.x-standard.x);
        }
        
        Collections.sort(point);
        
        Stack<Point> stack = new Stack<>();
        stack.push(standard);
        for(Point out : point) {
        	while(stack.size() >= 2 && ccw(stack.get(stack.size() - 2), stack.peek(), out) < 0) {
                stack.pop();
            }
            stack.push(out);
        }
        
        List<Point> hull = new ArrayList<>(stack);
        
        long min = Integer.MAX_VALUE;
        int j = 1;
        
        for (int i = 0; i < hull.size(); i++) {
            int ni = (i+1) % hull.size();

            while (area(hull.get(i), hull.get(ni), hull.get((j + 1) % hull.size())) > 
                   area(hull.get(i), hull.get(ni), hull.get(j))) {
                j = (j+1) % hull.size();
            }

            min = Math.min(min, Point.getDist(hull.get(i), hull.get(j)));
            min = Math.min(min, Point.getDist(hull.get(ni), hull.get(j)));
        }

        double result = Math.sqrt(min);
        
        System.out.println(result);
	}
	
	public static long area(Point a, Point b, Point c) {
        return Math.abs((b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x));
    }
	
	public static int ccw(Point a, Point b, Point c) {
		long calc = (b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x);
		if(calc > 0) return 1;
		else if(calc < 0) return -1;
		else return 0;
	}
	
	public static class Point implements Comparable<Point> {
		long x, y;
		double angle;
		
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
		
		private static long getDist(Point a, Point b) {
			return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
		}

		@Override
		public int compareTo(Point o) {
			if(this.angle == o.angle) return Long.compare(getDist(standard, this), getDist(standard, o));
			return Double.compare(this.angle, o.angle);
		}
	}
}