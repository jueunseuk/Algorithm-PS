package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_25195_YesOrYes {
	static int n, m, s;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] visit;
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	list.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
        
        s = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < s; i++) {
        	set.add(Integer.parseInt(st.nextToken()));
        }
        
        bfs();
	}

	private static void bfs() {
	    Queue<Integer> q = new ArrayDeque<>();
	    visit = new boolean[n + 1];

	    q.offer(1);
	    visit[1] = true;

	    while (!q.isEmpty()) {
	        int now = q.poll();

	        if (set.contains(now)) continue;

	        if (list.get(now).isEmpty()) {
	            System.out.println("yes");
	            return;
	        }

	        for (int next : list.get(now)) {
	            if (!visit[next]) {
	                q.offer(next);
	                visit[next] = true;
	            }
	        }
	    }

	    System.out.println("Yes");
	}
}