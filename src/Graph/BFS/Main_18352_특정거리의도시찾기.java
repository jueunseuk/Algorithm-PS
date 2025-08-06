package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18352_특정거리의도시찾기 {
	static int n, m, k, x;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] dist;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	list.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
        
        bfs(x);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
        	if(dist[i] == k) {
        		sb.append(i+"\n");
        	}
        }
        
        if(sb.length() > 0) {
        	System.out.println(sb.toString().trim());
        } else {
        	System.out.println(-1);
        }
	}

	private static void bfs(int i) {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[n+1];
		
		q.offer(new int[] {i, 0});
		visit[i] = true;
		dist[i] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			dist[poll[0]] = Math.min(dist[poll[0]], poll[1]);
			
			for(int out : list.get(poll[0])) {
				if(!visit[out]) {
					visit[out] = true;
					q.offer(new int[] {out, poll[1]+1});
				}
			}
		}
	}
}