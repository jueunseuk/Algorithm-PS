package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_31780_불사조 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        
        int sum = x;
        for(int i = 0; i < m; i++) {
        	int size = q.size();
        	
        	for(int j = 0; j < size; j++) {
        		int poll = q.poll();
        		int first = 0;
        		int second = 0;
        		
        		if(poll % 2 == 0) {
        			first = second = poll/2;
        		} else {
        			first = poll/2;
        			second = first+1;
        		}
        		
        		q.offer(first);
        		q.offer(second);
        		
        		sum += first+second;
        	}
        }

        System.out.println(sum);
	}
}