package Graph.TopologicalSort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1766_문제집 {
	static int n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] top;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        top = new int[n+1];
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(end);
        	top[end]++;
        }
        
        top();
        
        System.out.println(sb.toString().trim());
	}

	private static void top() {
		Queue<Integer> q = new PriorityQueue<>();
		
		for(int i = 1; i <= n; i++) {
			if(top[i] == 0) {
				q.offer(i);
			}
		}

		while(!q.isEmpty()) {
			int poll = q.poll();
			
			sb.append(poll+" ");
			
			for(int out : list.get(poll)) {
				if(--top[out] == 0) {
					q.offer(out);
				}
			}
		}
	}

}
