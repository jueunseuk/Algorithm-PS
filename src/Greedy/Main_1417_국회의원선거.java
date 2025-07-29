package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_1417_국회의원선거 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int dasom = Integer.parseInt(br.readLine());
		
		Queue<Candidate> q = new PriorityQueue<>();
		for(int i = 1; i < n; i++) {
			q.offer(new Candidate(i, Integer.parseInt(br.readLine())));
		}
		
		int cnt = 0;
		while(true) {
			if(q.isEmpty() || dasom > q.peek().poll) {
				break;
			}
			
			Candidate c = q.poll();
			c.poll--;
			cnt++;
			dasom++;
			
			q.offer(c);
		}

		System.out.println(cnt);
	}
	
	public static class Candidate implements Comparable<Candidate> {
		int idx, poll;
		
		public Candidate(int idx, int poll) {
			this.idx = idx;
			this.poll = poll;
		}

		@Override
		public int compareTo(Candidate o) {
			return o.poll - this.poll;
		}
	}
}