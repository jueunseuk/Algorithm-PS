package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15708_미네크래프트 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int max = 0, sum = 0;
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
        	int input = Integer.parseInt(st.nextToken());
        	
        	q.offer(input);
        	sum += input;
        	
        	while(sum > T - i*K && !q.isEmpty()) {
        		sum -= q.poll();
        	}
        	
        	max = Math.max(max, q.size());
        }
        
        System.out.println(max);
	}

}
