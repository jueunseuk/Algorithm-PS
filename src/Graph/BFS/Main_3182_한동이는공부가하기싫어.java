package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main_3182_한동이는공부가하기싫어 {
	static int n, maxV = 0, maxN = 0;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean visit[];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 1 ; i <= n; i++) {
        	list.get(i).add(Integer.parseInt(br.readLine()));
        }
        
        for(int i = 1; i <= n; i++) {
        	bfs(i);
        }

        System.out.println(maxN);
	}

	private static void bfs(int i) {
		Queue<Integer> q = new ArrayDeque<>();
		visit = new boolean[n+1];
		
		q.offer(i);
		visit[i] = true;
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			int dir = list.get(poll).get(0);
			if(!visit[dir]) {
				q.offer(dir);
				visit[dir] = true;
				cnt++;
			}
		}
		
		if(cnt > maxV) {
			maxN = i;
			maxV = cnt;
		}
	}

}
