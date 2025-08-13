package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_18112_이진수게임 {
	static int start, target;
	static boolean[] visit = new boolean[1 << 11];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		start = Integer.parseInt(br.readLine(), 2);
		target = Integer.parseInt(br.readLine(), 2);
		
		bfs();
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {start, 0});
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == target) {
				System.out.println(poll[1]);
				return;
			}
			
			int len = Integer.toBinaryString(poll[0]).length();

            for (int b = 0; b < len - 1; b++) {
                int mask = 1 << b;
                int nc = poll[0] ^ mask;
                if (!visit[nc]) {
                    visit[nc] = true;
                    q.offer(new int[]{nc, poll[1] + 1});
                }
            }
			
			if(poll[0] + 1 < visit.length && !visit[poll[0]+1]) {
				q.offer(new int[] {poll[0]+1, poll[1]+1});
				visit[poll[0]+1] = true;
			}
			
			if(poll[0] >= 1 && !visit[poll[0]-1]) {
				q.offer(new int[] {poll[0]-1, poll[1]+1});
				visit[poll[0]-1] = true;
			}
		}
	}
}