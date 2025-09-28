package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_22868_산책 {
	static int n, m, s, e;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] parent;
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
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(end);
        	list.get(end).add(start);
        }
        
        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        
        int distSE = searchSE();
        int distES = searchES();

        System.out.println(distSE + distES);
	}

	private static int searchSE() {
        Queue<Integer> q = new ArrayDeque<>();
        parent = new int[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        q.offer(s);
        dist[s] = 0;
        
        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == e) {
                break; 
            }

            for (int next : list.get(current)) {
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    parent[next] = current;
                    q.offer(next);
                }
            }
        }

        int curr = e;
        while (curr != s) {
            int p = parent[curr];
            if (p != s) {
                set.add(p);
            }
            curr = p;
        }

        return dist[e];
    }

    private static int searchES() {
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        q.offer(e);
        dist[e] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == s) {
                return dist[s];
            }

            for (int next : list.get(current)) {
                if (dist[next] == -1 && !set.contains(next)) {
                    dist[next] = dist[current] + 1;
                    q.offer(next);
                }
            }
        }
        return -1;
    }
}