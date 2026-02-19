package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_8979_올림픽 {
	static class Country implements Comparable<Country> {
		int idx;
		int gold;
		int silver;
		int bronze;
		int rank;
		
		public Country(int idx, int gold, int silver, int bronze) {
			this.idx = idx;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		
		@Override
		public int compareTo(Country o) {
			if(o.gold == this.gold) {
				if(o.silver == this.silver) {
					return o.bronze - this.bronze;
				}
				return o.silver - this.silver;
			}
			return o.gold - this.gold;
		}
	}

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Queue<Country> q = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	q.offer(new Country(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        int cnt = 1;
        int rank = 1;
        Country prev = q.poll();
        prev.rank = 1;
        
        if(prev.idx == k) {
        	System.out.println(1);
        	return;
        }
        
        while(!q.isEmpty()) {
        	Country curr = q.poll();
        	if(prev.gold == curr.gold && prev.silver == curr.silver && prev.bronze == curr.bronze) {
        		curr.rank = rank;
        		cnt++;
        	} else {
        		rank += cnt;
        		curr.rank = rank;
        		prev = curr;
        		cnt = 1;
        	}
        	
        	if(curr.idx == k) {
        		System.out.println(curr.rank);
        		return;
        	}
        }
	}
}