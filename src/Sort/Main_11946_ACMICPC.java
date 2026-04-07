package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11946_ACMICPC {
	static int n, m, query;
	
	static class Team implements Comparable<Team> {
		int idx;
		int solved;
		int sum;
		int[] cnt;
		boolean[] isSolved;
		
		public Team(int idx) {
			this.idx = idx;
			cnt = new int[m];
			isSolved = new boolean[m];
		}
		
		private void solving(int question, int taken) {
			if(isSolved[question]) return;
			isSolved[question] = true;
			solved++;
			sum += taken;
			sum += cnt[question]*20;
		}
		
		private void wrong(int question) {
			if(isSolved[question]) return;
			cnt[question]++;
		}

		@Override
		public int compareTo(Team o) {
			if(this.solved == o.solved) {
				if(o.sum == this.sum) {
					return this.idx - o.idx;
				}
				return this.sum - o.sum;
			}
			return o.solved - this.solved;
		}
	}

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 팀 수
        m = Integer.parseInt(st.nextToken()); // 문제 수
        query = Integer.parseInt(st.nextToken()); // 채점 수
        
        Team[] teams = new Team[n];
        for(int i = 0; i < n; i++) {
        		teams[i] = new Team(i);
        }
        
        for(int q = 0; q < query; q++) {
        		st = new StringTokenizer(br.readLine(), " ");
	        	int time = Integer.parseInt(st.nextToken());
	        	int team = Integer.parseInt(st.nextToken())-1;
	        	int question = Integer.parseInt(st.nextToken())-1;
	        	String result = st.nextToken();
	        	
	        	if(result.equals("AC")) {
	        		teams[team].solving(question, time);
	        	} else {
	        		teams[team].wrong(question);
	        	}
        }
        
        Arrays.sort(teams);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
    			sb.append(teams[i].idx+1).append(" ").append(teams[i].solved).append(" ").append(teams[i].sum).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}