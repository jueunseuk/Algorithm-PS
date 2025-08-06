package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17071_숨바꼭질5 {
	static int size = 500000, s, d;
	static int subin[][] = new int[size+1][2];
	
	static final int dx[] = {1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " "	);
		s = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		bfsS();
		int result = calcD();
		System.out.println(result);
	}

	private static int calcD() {
		for (int t = 0; ; t++) {
            int bro = d + t * (t + 1) / 2;
            
            if (bro > size) break;
            
            int parity = t & 1;
            if (subin[bro][parity] != -1 && subin[bro][parity] <= t) {
            	return t;
            }
        }
		
		return -1;
	}

	private static void bfsS() {
		Queue<int[]> q = new ArrayDeque<>();
		for(int i = 0; i <= size; i++) {
			Arrays.fill(subin[i], -1);
		}
		
		q.offer(new int[] {s, 0});
		subin[s][0] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int nt = poll[1] + 1;
			int parity = nt & 1;
			
			int nx = poll[0] << 1;
			if(nx <= size && subin[nx][parity] == -1) {
				q.offer(new int[] {nx, nt});
				subin[nx][parity] = nt;
			}
			
			for(int delta = 0; delta < 2; delta++) {
				nx = poll[0] + dx[delta];
				
				if(nx >= 0 && nx <= size && subin[nx][parity] == -1) {
					q.offer(new int[] {nx, nt});
					subin[nx][parity] = nt;
				}
			}
		}
	}
}