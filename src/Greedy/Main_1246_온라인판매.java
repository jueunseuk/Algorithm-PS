package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1246_온라인판매 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < m; i++) {
        	pq.offer(Integer.parseInt(br.readLine()));
        }
        
        int price = 0;
        int max = 0;
        while(!pq.isEmpty()) {
        	if(max < (m-pq.size()+1) * pq.peek()) {
        		max = (m-pq.size()+1) * pq.peek();
        		price = pq.peek();
        	}
        	pq.poll();
        	if(--n == 0) break;
        }
        
        System.out.println(price+" "+max);
	}
}