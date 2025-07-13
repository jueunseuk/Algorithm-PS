package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_31872_강의실 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        int input[] = new int[n+1];
        
        for(int i = 0 ; i < n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(input);
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < n; i++) {
        	q.offer(input[i+1]-input[i]);
        }
        
        for(int i = 0; i < k; i++) {
        	q.poll();
        }
        
        long sum = 0;
        for(int out : q) {
        	sum += out;
        }
        
        System.out.println(sum);

	}

}
