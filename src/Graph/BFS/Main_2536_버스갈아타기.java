package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2536_버스갈아타기 {
	static int row, col, busCnt;
	static Bus[] bus;
	static boolean[] use;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		busCnt = Integer.parseInt(br.readLine());
		bus = new Bus[busCnt+1];
		
		for(int i = 0; i < busCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			bus[idx] = new Bus(idx, sx, sy, ex, ey);
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
		use = new boolean[busCnt+1];
		
		for(Bus b : bus) {
			if(isInline(sx, sy, b)) {
				q.offer(b);
				use[b.idx] = true;
			}
		}
		
		while(!q.isEmpty()) {
			Bus poll = q.poll();
			
			if(isInline(ex, ey, poll)) {
				System.out.println();
				return;
			}
		}
	}
	
	private static boolean isInline(int x, int y, Bus b) {
		if(x == b.sx && y >= b.sy && y <= b.ey) {
			return true;
		}
		if(x >= b.sx && x <= b.ex && y == b.sy) {
			return true;
		}
		return false;
	}

	static class Bus {
		int idx, sx, sy, ex, ey;
		
		public Bus(int idx, int sx, int sy, int ex, int ey) {
			this.idx = idx;
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
		}
	}
}