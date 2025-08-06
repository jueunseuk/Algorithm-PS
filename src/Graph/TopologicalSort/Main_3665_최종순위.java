package Graph.TopologicalSort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3665_최종순위 {
	static int n, k;
	static List<List<Integer>> list;
	static int top[];
	static int input[];
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int t = 0; t < T; t++) {
        	n = Integer.parseInt(br.readLine());
        	
        	list = new ArrayList<>();
        	for(int i = 0; i <= n; i++) {
        		list.add(new ArrayList<>());
        	}
        	
        	input = new int[n+1];
        	top = new int[n+1];
        	
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int i = 0; i < n; i++) {
        		input[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	k = Integer.parseInt(br.readLine());
        	
        	for(int i = 0; i < n; i++) {
        		for(int j = i+1; j < n; j++) {
        			list.get(input[i]).add(input[j]);
        			top[input[j]]++;
        		}
        	}
        	
        	for(int i = 0; i < k; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int front = Integer.parseInt(st.nextToken());
        		int end = Integer.parseInt(st.nextToken());
        		
        		if(list.get(front).contains(end)) {
        			list.get(front).remove(Integer.valueOf(end));
        			list.get(end).add(front);
        			top[front]++;
        			top[end]--;
        		} else {
        			list.get(end).remove(Integer.valueOf(front));
        			list.get(front).add(end);
        			top[end]++;
        			top[front]--;
        		}
        	}
        	
        	topologicalSort();
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void topologicalSort() {
		Queue<Integer> q = new ArrayDeque<>();
		
		StringBuilder temp = new StringBuilder();
		
		for(int i = 1; i <= n; i++) {
			if(top[i] == 0) {
				q.offer(i);
			}
		}
		
		if(q.size() > 1) {
			sb.append("?"+"\n");
			return;
		}
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			temp.append(poll+" ");
			
			for(int out : list.get(poll)) {
				if(--top[out] == 0) {
					q.offer(out);
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(top[i] > 0) {
				sb.append("IMPOSSIBLE"+"\n");
				return;
			}
		}
		
		temp.deleteCharAt(temp.length()-1);
		sb.append(temp+"\n");
	}
}