package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13164_행복유치원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int []high = new int[N];
		
		for(int i = 0; i < N; i++) {
			high[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(high);
		
		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < N-1; i++) {
			q.offer(high[i+1]-high[i]);
		}
		
		for(int i = 0; i < K-1; i++) {
			q.poll();
		}
		
		long result = 0;
		for(Integer out : q) {
			result += out;
		}
		
		System.out.println(result);
	}

}
