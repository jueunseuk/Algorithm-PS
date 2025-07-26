package Adhoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21316_스피카 {
	static int n = 12, m = 12;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.get(start).add(end);
			list.get(end).add(start);
		}
		
		int[] ans = new int[n+1];
		ans[1]++;
		ans[3]++;
		ans[3]++;
		ans[5]++;
		
		for(int i = 1; i <= n; i++) {
			int[] calc = bfs(i);
			
			boolean flag = true;
			for(int j = 1; j <= n; j++) {
				if(calc[j] != ans[j]) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				System.out.println(i);
				break;
			}
		}
	}

	private static int[] bfs(int i) {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[n+1];
		
		q.offer(new int[] {i, 0});
		visit[i] = true;
		
		int[] end = new int[n+1];
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(list.get(poll[0]).size() == 1) {
				end[poll[1]]++;
			}
			
			for(int out : list.get(poll[0])) {
				if(!visit[out]) {
					q.offer(new int[] {out, poll[1]+1});
					visit[out] = true;
				}
			}
		}
		
		return end;
	}
}