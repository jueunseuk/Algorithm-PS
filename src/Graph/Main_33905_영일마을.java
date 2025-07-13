package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_33905_영일마을 {
	static int n, m, k, cnt = 0;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean visit[];
	
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken())+1;
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        visit = new boolean[n+1];
        
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
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < k; i++) {
        	set.add(Integer.parseInt(st.nextToken()));
        }
        
        bfs(1);
        
        System.out.println(cnt);
	}

	private static void bfs(int i) {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(i);
		visit[i] = true;
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int out : list.get(poll)) {
				if(!visit[out] && !set.contains(out)) {
					q.offer(out);
					visit[out] = true;
					cnt++;
				}
			}
		}
	}
}