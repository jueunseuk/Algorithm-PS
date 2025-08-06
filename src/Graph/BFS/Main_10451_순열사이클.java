package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10451_순열사이클 {
	static int n, cnt;
	static List<List<Integer>> list;
	static boolean visit[];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			
			list = new ArrayList<>();
			visit = new boolean[n+1];
			for(int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= n; i++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i = 1; i <= n; i++) {
				if(!visit[i]) {
					bfs(i);
					cnt++;
				}
			}
			
			sb.append(cnt+"\n");
		}
		
		br.close();
		System.out.println(sb.toString().trim());
	}


	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(i);
		visit[i] = true;
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int out : list.get(poll)) {
				if(visit[out]) {
					return;
				} else {
					q.offer(out);
					visit[out] = true;
				}
			}
		}
	}
}