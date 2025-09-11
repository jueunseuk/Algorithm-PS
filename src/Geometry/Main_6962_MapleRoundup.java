package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_6962_MapleRoundup {
	static Point standard;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	int n = Integer.parseInt(br.readLine());
        	
        	List<Point> point = new ArrayList<>();
        	for(int i = 0; i < n; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		point.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        	}
        	
        	standard = Collections.min(point, (a, b) -> {
        		if(a.y != b.y) return Integer.compare(a.y, b.y);
        		return Integer.compare(a.x, b.x);
        	});
        	
        	point.remove(standard);
        	
        	for(Point p : point) {
        		p.angle = Math.atan2(p.y-standard.y, p.x-standard.x);
        	}
        	
        	Collections.sort(point);
        	
        	Stack<Point> stack = new Stack<>();
        	stack.push(standard);
        	for(Point out : point) {
            	while(stack.size() >= 2 && ccw(stack.get(stack.size() - 2), stack.peek(), out) <= 0) {
                    stack.pop();
                }
                stack.push(out);
            }
        	stack.push(standard);
        	
        	double dist = 0;
        	for(int i = 0; i < stack.size(); i++) {
        		dist += calc(stack.get(i), stack.get((i+1) % stack.size()));
        	}
        	
        	sb.append(String.format("%.2f", dist)).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
	
	private static double calc(Point a, Point b) {
		return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
	}

	public static int ccw(Point a, Point b, Point c) {
		long calc = (b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x);
		if(calc > 0) return 1;
		else if(calc < 0) return -1;
		else return 0;
	}

	public static class Point implements Comparable<Point>{
		int x, y;
		double angle;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		private static int getDist(Point a, Point b) {
			return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
		}

		@Override
		public int compareTo(Point o) {
			if(this.angle == o.angle) return Integer.compare(getDist(standard, this), getDist(standard, o));
			return Double.compare(this.angle, o.angle);
		}
	}
}