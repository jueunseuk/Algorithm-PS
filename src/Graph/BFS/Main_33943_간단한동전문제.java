package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_33943_간단한동전문제 {
	static int target, c, size = 12000;
	static int[] pos, neg, coin;
	static boolean[] visitn, visitp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		c = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		
		coin = new int[c];
		
		if(c != 0) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < c; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		pos = new int[size];
		visitp = new boolean[size];
		neg = new int[size];
		visitn = new boolean[size];
		
		bfs();
	}
	
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {0, 0});
		visitp[0] = true;
		visitn[0] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == target) {
				System.out.println(poll[1]);
				return;
			}
			
			for(int out : coin) {
				int nv = poll[0] + out;
				
				if(nv > 0) {
					if(nv < size && !visitp[nv]) {
						q.offer(new int[] {nv, poll[1] + 1});
						visitp[nv] = true;
					}
				} else {
					nv *= -1;
					if(nv < size && !visitn[nv]) {
						q.offer(new int[] {-nv, poll[1] + 1});
						visitn[nv] = true;
					}
				}
			}
		}
		
		System.out.println(-1);
	}
}