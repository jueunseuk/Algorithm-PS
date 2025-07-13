package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1325_효율적인해킹 {
	static int n, m;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] visit;
	static int[] result;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	result = new int[n+1];
    	visit = new boolean[n+1];
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	list.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
        
        for(int i = 1; i <= n; i++) {
        	bfs(i);
        }
        
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
        	if(result[i] > max) {
        		max = result[i];
        		sb = new StringBuilder(i+" ");
        	} else if(result[i] == max) {
        		sb.append(i+" ");
        	}
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void bfs(int i) {
		Queue<Integer> q = new ArrayDeque<>();
		visit = new boolean[n+1];
		
		q.offer(i);
		visit[i] = true;
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int out : list.get(poll)) {
				if(!visit[out]) {
					q.offer(out);
					result[out]++;
					visit[out] = true;
				}
			}
		}
	}
}