package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_28069_김밥천국의계단 {
	static int n, limit;
	static int[] arr;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        
        arr = new int[n+1];
        visit = new boolean[n+1];
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        
        boolean flag = false;
        while(!q.isEmpty()) {
        	int[] poll = q.poll();
        	
        	if(poll[0] == n && poll[1] <= limit) {
        		flag = true;
        		break;
        	}
        	
        	if(poll[1] > limit) continue;
        	
        	int nx = poll[0] + 1;
        	if(nx <= n && !visit[nx]) {
        		visit[nx] = true;
        		q.offer(new int[] {nx, poll[1]+1});
        	}
        	
        	int ny = poll[0] + poll[0] / 2;
        	if(ny <= n && !visit[ny]) {
        		visit[ny] = true;
        		q.offer(new int[] {ny, poll[1]+1});
        	}
        }
        
        System.out.println(flag ? "minigimbob" : "water");
	}
}