package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_35349_CardGame4 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Queue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	int input = Integer.parseInt(st.nextToken());
        	if(input % 2 == 1) {
        		odd.offer(input);
        	} else {
        		even.offer(input);
        	}
        }
        
        if(odd.size() < k && even.size() < k) {
        	System.out.println(0);
        } else if(odd.size() < k) {
        	long sum = 0;
        	for(int i = 0; i < k; i++) {
        		sum += even.poll();
        	}
        	System.out.println(sum);
        } else if(even.size() < k) {
        	long sum = 0;
        	for(int i = 0; i < k; i++) {
        		sum += odd.poll();
        	}
        	System.out.println(sum);
        } else {
        	long oddSum = 0;
        	long evenSum = 0;
        	for(int i = 0; i < k; i++) {
        		oddSum += odd.poll();
        		evenSum += even.poll();
        	}
        	
        	System.out.println(Math.max(oddSum, evenSum));
        }
	}
}