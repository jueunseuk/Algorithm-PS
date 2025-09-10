package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17403_가장높고넓은성 {
	static Point standard;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n];
        
        List<Point> point = new ArrayList<>();
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	point.add(new Point(i, Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }
        
        int idx = 1;
        while(true) {
        	List<Point> cur = new ArrayList<>(point);
        	
        	standard = Collections.min(cur, (a, b) -> {
        		if(a.y != b.y) return Long.compare(a.y, b.y);
        		return Long.compare(a.x, b.x);
        	});
        	
        	for(Point out : cur) {
        		out.angle = Math.atan2(out.y-standard.y, out.x-standard.x);
        	}
        	
        	Collections.sort(cur);
        	
        	Stack<Point> stack = new Stack<>();
        	for(Point out : cur) {
        		while(stack.size() >= 2 && ccw(stack.get(stack.size() - 2), stack.peek(), out) <= 0) {
        			stack.pop();
        		}
        		stack.push(out);
        	}
        	
        	if(stack.size() >= 3) {
        		for(Point out : stack) {
        			result[out.idx] = idx;
        			point.remove(out);
        		}
        		
        		idx++;
        	} else {
        		break;
        	}
        	
        	if(point.size() <= 2) break;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int out : result) {
        	sb.append(out+" ");
        }
        
        System.out.println(sb.toString().trim());
	}
	
	public static int ccw(Point a, Point b, Point c) {
		long calc = (b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x);
		if(calc > 0) return 1;
		else if(calc < 0) return -1;
		else return 0;
	}
	
	public static class Point implements Comparable<Point> {
		int idx;
		long x, y;
		double angle;
		
		public Point(int idx, long x, long y) {
			this.idx = idx;
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