package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_34117_허수아비 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        long power = Integer.parseInt(st.nextToken());
        
        long[] target = new long[n];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	target[i] = Integer.parseInt(st.nextToken());
        }
        
        Queue<Long> q = new PriorityQueue<>();
        
        int[] result = new int[n];
        
        long curr = 0;
        for(int i = 0; i < n; i++) {
        	q.offer(target[i]);
        	curr += target[i];
        	
        	if(curr < power) {
        		result[i] = -1;
        		continue;
        	}
        	
    		while(!q.isEmpty()) {
    			if(curr - q.peek() >= power) {
    				curr -= q.poll();
    			} else {
    				break;
    			}
    		}
    		
    		result[i] = q.size();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
        	sb.append(result[i]+" ");
        }
        
        System.out.println(sb.toString().trim());
	}
}