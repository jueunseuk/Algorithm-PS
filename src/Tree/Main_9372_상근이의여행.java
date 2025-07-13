package Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9372_상근이의여행 {
	static int n, m, cnt;
	static List<List<Integer>> list;
	static boolean visit[];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	cnt = 0;

        	visit = new boolean[n];
        	list = new ArrayList<>();
        	for(int i = 0; i < n; i++) {
        		list.add(new ArrayList<>());
        	}
        	
        	for(int i = 0; i < m; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int start = Integer.parseInt(st.nextToken())-1;
        		int end = Integer.parseInt(st.nextToken())-1;
        		
        		list.get(start).add(end);
        		list.get(end).add(start);
        	}
        	
        	for(int i = 0; i < n; i++) {
        		if(!visit[i]) {
        			bfs(i);
        		}
        	}
        	
        	sb.append(cnt+"\n");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		
		visit[i] = true;
		q.offer(i);
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(Integer out : list.get(poll)) {
				if(!visit[out]) {
					q.offer(out);
					visit[out] = true;
					cnt++;
				}
			}
		}
	}

}
