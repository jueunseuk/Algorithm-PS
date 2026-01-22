package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18243_SmallWorldNetwork {
	static int n, m;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean [] visit;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(end);
        	list.get(end).add(start);
        }
        
		for(int i = 1; i <= n; i++) {
			if(!bfs(i)) {
				System.out.println("Big World!");
				return;
			}
		}
		
		System.out.println("Small World!");
	}

	private static boolean bfs(int start) {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[n+1];
		
		visit[start] = true;
		q.offer(new int[] {start, 0});
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] >= 6) {
				continue;
			}
			
			for(int out : list.get(poll[0])) {
				if(!visit[out]) {
					q.offer(new int[] {out, poll[1]+1});
					visit[out] = true;
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visit[i]) {
				return false;
			}
		}
		
		return true;
	}
}