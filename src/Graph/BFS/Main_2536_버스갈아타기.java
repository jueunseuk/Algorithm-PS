package Graph.BFS;

import java.io.BufferedReader;
<<<<<<< HEAD
=======
import java.io.IOException;
>>>>>>> ce117957cd38a73201372582cbba5e83ec7aa786
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2536_버스갈아타기 {
	static int row, col, busCnt;
	static Queue<Bus> bus = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		busCnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < busCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			bus.offer(new Bus(idx, sx, sy, ex, ey));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		int ex = Integer.parseInt(st.nextToken());
		int ey = Integer.parseInt(st.nextToken());
		
		bfs(sx, sy, ex, ey);
	}
	
	private static void bfs(int sx, int sy, int ex, int ey) {
		Queue<Bus> q = new ArrayDeque<>();
		
		int size = bus.size();
		for(int i = 0; i < size; i++) {
			Bus curr = bus.poll();
			if(isInline(sx, sy, curr)) {
				q.offer(curr);
			} else {
				bus.offer(curr);
			}
		}
		
		while(!q.isEmpty()) {
			Bus poll = q.poll();
			
			if(isInline(ex, ey, poll)) {
				System.out.println(poll.trans);
				return;
			}
			
			size = bus.size();
			for(int i = 0; i < size; i++) {
				Bus target = bus.poll();
				
				if(isIntersect(poll, target)) {
					target.trans = poll.trans+1;
					q.offer(target);
				} else {
					bus.offer(target);
				}
			}
		}
	}
	
	private static boolean isInline(int x, int y, Bus b) {
	    if(b.sx == b.ex) {
	        return x == b.sx && y >= b.sy && y <= b.ey;
	    }
	    else {
	        return y == b.sy && x >= b.sx && x <= b.ex;
	    }
	}
	
	private static boolean isIntersect(Bus a, Bus b) {
		int ab1 = getCCW(a.sx, a.sy, a.ex, a.ey, b.sx, b.sy);
		int ab2 = getCCW(a.sx, a.sy, a.ex, a.ey, b.ex, b.ey);
		int cd1 = getCCW(b.sx, b.sy, b.ex, b.ey, a.sx, a.sy);
		int cd2 = getCCW(b.sx, b.sy, b.ex, b.ey, a.ex, a.ey);

		if(ab1 == 0 && ab2 == 0 && cd1 == 0 && cd2 == 0) {
			return Math.max(Math.min(a.sx, a.ex), Math.min(b.sx, b.ex))
					<= Math.min(Math.max(a.sx, a.ex), Math.max(b.sx, b.ex))
				&& Math.max(Math.min(a.sy, a.ey), Math.min(b.sy, b.ey))
					<= Math.min(Math.max(a.sy, a.ey), Math.max(b.sy, b.ey));
		}

		return ab1 * ab2 <= 0 && cd1 * cd2 <= 0;
	}
	
	private static int getCCW(int x1, int y1, int x2, int y2, int x3, int y3) {
		long result = (long)(x2 - x1) * (y3 - y1) - (long)(y2 - y1) * (x3 - x1);
		
		if(result > 0) return 1;
		if(result < 0) return -1;
		return 0;
	}

	static class Bus {
		int idx, sx, sy, ex, ey, trans;
		
		public Bus(int idx, int sx, int sy, int ex, int ey) {
		    this.idx = idx;
		    this.sx = Math.min(sx, ex);
		    this.sy = Math.min(sy, ey);
		    this.ex = Math.max(sx, ex);
		    this.ey = Math.max(sy, ey);
		    this.trans = 1;
		}
	}
}