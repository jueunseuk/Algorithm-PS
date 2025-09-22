package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_24446_알고리즘수업너비우선탐색3 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        
        List<List<Integer>> list = new ArrayList<>();
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
        
        int[] result = new int[n+1];
        
        Arrays.fill(result, -1);
        
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[] {s, 0});
        result[s] = 0;
        
        while(!q.isEmpty()) {
        	int[] poll = q.poll();
        	
        	for(int out : list.get(poll[0])) {
        		if(result[out] == -1) {
        			q.offer(new int[] {out, poll[1]+1});
        			result[out] = poll[1]+1;
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
        	sb.append(result[i]+"\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}