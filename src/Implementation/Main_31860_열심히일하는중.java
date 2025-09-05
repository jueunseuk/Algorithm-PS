package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_31860_열심히일하는중 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < n; i++) {
        	q.offer(Integer.parseInt(br.readLine()));
        }
        
        int day = 0;
        int satis = 0;
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
        	int poll = q.poll();

        	satis = satis/2 + poll;
        	sb.append(satis+"\n");
        	
        	if(poll - m > k) q.offer(poll-m);
        	
        	day++;
        }
        
        System.out.println(day);
        System.out.println(sb.toString().trim());
	}
}