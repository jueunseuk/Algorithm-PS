package Graph.TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_31854_부등호퍼즐 {
	static int n, sq;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] top;
	static int[] result;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        sq = n*n;
        
        top = new int[sq+1];
        result = new int[sq+1];
        for(int i = 0; i <= sq; i++) {
        		list.add(new ArrayList<>());
        }
        
        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for(int j = 1; j < n; j++) {
        			int start = (i-1)*n + j;
        			int end = start+1;
        			
        			if(st.nextToken().equals("<")) {
        				list.get(start).add(end);
        				top[end]++;
        			} else {
        				list.get(end).add(start);
        				top[start]++;
        			}
        		}
        }
        
        for(int i = 1; i < n; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
	        	for(int j = 1; j <= n; j++) {
	        		int start = (i-1)*n + j;
	        		int end = start+n;
	        		
	        		if(st.nextToken().equals("<")) {
	        			list.get(start).add(end);
	        			top[end]++;
	        		} else {
	        			list.get(end).add(start);
	        			top[start]++;
	        		}
	        	}
        }
        
        topologicalSort();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= sq; i++) {
    			sb.append(result[i]+" ");
    			if(i % n == 0) sb.append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
	
	private static void topologicalSort() {
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1; i <= sq; i++) {
			if(top[i] == 0) {
				q.offer(i);
			}
		}
		
		int idx = 1;
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			result[poll] = idx++;
			
			for(int out : list.get(poll)) {
				if(--top[out] == 0) {
					q.offer(out);
				}
			}
		}
	}
}
