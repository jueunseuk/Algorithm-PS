package Geometry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main_2699_격자점컨벡스헐 {
	static Point standard;

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
        
        int T = rd.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	int n = rd.nextInt();
        	
        	List<Point> point = new ArrayList<>();
        	
        	for(int i = 0; i < n; i++) {
        		point.add(new Point(rd.nextLong(), rd.nextLong()));
        	}
        	
        	standard = Collections.max(point, (a, b) -> {
        		if (a.y != b.y) return Long.compare(a.y, b.y);
        		return Long.compare(b.x, a.x);
        	});
        	
        	point.remove(standard);
        	
        	for(Point out : point) {
        		out.angle = Math.atan2(out.y-standard.y, out.x-standard.x);
        	}
        	
        	Collections.sort(point);
        	
        	Stack<Point> stack = new Stack<>();
        	stack.push(standard);
        	for(Point out : point) {
        		while(stack.size() >= 2 && ccw(stack.get(stack.size() - 2), stack.peek(), out) >= 0) {
        			stack.pop();
        		}
        		stack.push(out);
        	}
        	
        	sb.append(stack.size()+"\n");
        	for(Point out : stack) {
        		sb.append(out.x+" "+out.y).append("\n");
        	}
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
			return Double.compare(o.angle, this.angle);
		}
	}
	
	static class Reader {
        private final int SIZE = 1 << 13;
        private final byte[] buffer = new byte[SIZE];
        private int index, size;

        int nextInt() throws IOException {
            int lis = 0;
            byte c;
            boolean isMinus = false;
            while ((c = read()) <= 32);
            if (c == 45) { c = read(); isMinus = true; }
            do lis = (lis << 3) + (lis << 1) + (c & 15);
            while (isnumber(c = read()));
            return isMinus ? ~lis + 1 : lis;
        }

        long nextLong() throws IOException {
            long val = 0L;
            byte c;
            boolean neg = false;
            while ((c = read()) <= 32);
            if (c == 45) {
                neg = true;
                c = read();
            }
            do val = (val << 3) + (val << 1) + (c & 15);
            while (isnumber(c = read()));
            return neg ? -val : val;
        }

        char nextChar() throws IOException {
            byte c;
            while ((c = read()) <= 32);
            return (char) c;
        }

        String nextString() throws IOException {
            StringBuilder sb = new StringBuilder();
            byte c;
            while ((c = read()) <= 32);
            do sb.append((char) c);
            while ((c = read()) > 32);
            return sb.toString();
        }

        private boolean isnumber(byte c) {
            return 47 < c && c < 58;
        }

        private byte read() throws IOException {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0) buffer[0] = -1;
            }
            return buffer[index++];
        }
    }
}