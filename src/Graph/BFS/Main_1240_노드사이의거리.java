package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1240_노드사이의거리 {
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n-1; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new int[] {end, w});
        	list.get(end).add(new int[] {start, w});
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int result = bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	sb.append(result+"\n");
        }
        
        br.close();
        
        System.out.println(sb.toString().trim());
	}

	private static int bfs(int i, int target) {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[n+1];
		
		q.offer(new int[] {i, 0});
		visit[i] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == target) {
				return poll[1];
			}
			
			for(int[] out : list.get(poll[0])) {
				if(!visit[out[0]]) {
					q.offer(new int[] {out[0], poll[1]+out[1]});
					visit[out[0]] = true;
				}
			}
		}
		
		return -1;
	}
}