package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2623_음악프로그램 {
	static int n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] top;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        top = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int temp = Integer.parseInt(st.nextToken());
        	
        	int curr = Integer.parseInt(st.nextToken());
        	int prev = curr;
        	for(int j = 0; j < temp-1; j++) {
        		curr = Integer.parseInt(st.nextToken());
        		list.get(prev).add(curr);
        		top[curr]++;
        		prev = curr;
        	}
        }
        
        topologicalSort();
        
        for(int out : top) {
        	if(out != 0) {
        		System.out.println(0);
        		return;
        	}
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void topologicalSort() {
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1; i <= n; i++) {
			if(top[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			sb.append(poll+"\n");
			
			for(int out : list.get(poll)) {
				top[out]--;
				if(top[out] == 0) {
					q.offer(out);
				}
			}
		}
	}
}