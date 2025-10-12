package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_21세일_11508 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
        	q.offer(Integer.parseInt(br.readLine()));
        }

        while(q.size() >= 3) {
        	result += q.poll();
        	result += q.poll();
        	q.poll();
        }
        
        while(!q.isEmpty()) {
        	result += q.poll();
        }
        
        System.out.println(result);
	}
}