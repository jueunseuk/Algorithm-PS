package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로 {
	static int n;
	static boolean visit[];
	static int[] arr;
	static int[] perm;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		visit = new boolean[n];
		perm = new int[n];
		
		bt(0);
		
		System.out.println(max);
	}

	private static void bt(int depth) {
		if(depth == n) {
			int sum = 0;
			for(int i = 1; i <= n; i++) {
				sum += Math.abs(perm[i-1]-perm[i]);
			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			perm[depth] = arr[i];
			bt(depth+1);
			visit[i] = false;
		}
	}
}