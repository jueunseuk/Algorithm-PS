package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_12786_INHASUIT {
	static int n, limit;
	static boolean[][] tree;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        limit = Integer.parseInt(br.readLine());
        
        tree = new boolean[21][n+1];
        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int cnt = Integer.parseInt(st.nextToken());
        		
        		for(int j = 0; j < cnt; j++) {
        			tree[Integer.parseInt(st.nextToken())][i] = true;
        		}
        }
        
        zerooneBFS();
	}

	private static void zerooneBFS() {
		Deque<int[]> dq = new ArrayDeque<>();
		visit = new boolean[21][n+1];
		
		dq.offer(new int[] {1, 0, 0});
		visit[1][0] = true;
		
		while(!dq.isEmpty()) {
			int[] poll = dq.pollFirst();
			
			visit[poll[0]][poll[1]] = true;
			
			if(poll[1] == n) {
				System.out.println(poll[2]);
				return;
			}
			
			int nh = poll[0];
			int nt = poll[1] + 1;
			if(!visit[nh][nt] && tree[nh][nt]) {
				dq.offerFirst(new int[] {nh, nt, poll[2]});
				visit[nh][nt] = true;
			}
			
			nh = poll[0] - 1;
			if(nh >= 1 && !visit[nh][nt] && tree[nh][nt]) {
				dq.offerFirst(new int[] {nh, nt, poll[2]});
			}

			nh = poll[0] >= 10 ? 20 : poll[0]*2;
			if(!visit[nh][nt] && tree[nh][nt]) {
				dq.offerFirst(new int[] {nh, nt, poll[2]});
			}
			
			nh = poll[0] + 1;
			if(nh <= 20 && !visit[nh][nt] && tree[nh][nt]) {
				dq.offerFirst(new int[] {nh, nt, poll[2]});
			}
			
			for(int i = 1; i <= 20; i++) {
				if(tree[i][nt] && !visit[i][nt] && limit > poll[2]) {
					dq.offerLast(new int[] {i, nt, poll[2]+1});
				}
			}
		}
		
		System.out.println(-1);
	}
}