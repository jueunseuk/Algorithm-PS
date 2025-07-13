package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2075_N번째큰수 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < n; j++)
        		q.add(Integer.parseInt(st.nextToken()));
        }
        
        for(int i = 0; i < n-1; i++) {
        	q.poll();
        }
        
        System.out.println(q.peek());
	}

}
