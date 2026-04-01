package Graph.TopologicalSort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9846_Rank {
	static int n, k;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] degree;

    static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        degree = new int[n+1];
        for(int i = 0; i <= n; i++) {
        		list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < k; i++) {
        		st = new StringTokenizer(br.readLine(), ">");
        		
        		StringTokenizer left = new StringTokenizer(st.nextToken(), ",");
        		StringTokenizer right = new StringTokenizer(st.nextToken(), ",");
        		
        		int start1 = Integer.parseInt(left.nextToken());
        		int end1 = Integer.parseInt(right.nextToken());
        		
        		list.get(start1).add(end1);
        		degree[end1]++;
        		
        		if(left.hasMoreTokens()) {
        			int start2 = Integer.parseInt(left.nextToken());
        			list.get(start2).add(end1);
        			degree[end1]++;
        		} else {
        			int end2 = Integer.parseInt(right.nextToken());
        			list.get(start1).add(end2);
        			degree[end2]++;
        		}
        }
        
        topSort();
        
        for(int out : degree) {
        		if(out != 0) {
        			System.out.println(0);
        			return;
        		}
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void topSort() {
		Queue<Integer> q = new PriorityQueue<>();
		
		for(int i = 1; i <= n; i++) {
			if(degree[i] == 0) {
				q.offer(i);
			}
		}

		while(!q.isEmpty()) {
			int poll = q.poll();
			
			sb.append(poll+" ");
			
			for(int out : list.get(poll)) {
				if(--degree[out] == 0) {
					q.offer(out);
				}
			}
		}
	}

}
