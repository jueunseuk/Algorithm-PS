package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14908_구두수선공 {

	public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Work[] work = new Work[n];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	work[i] = new Work(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	work[i].calc();
        }
        
        Arrays.sort(work);
        
        StringBuilder sb = new StringBuilder();
        for (Work w : work) {
            sb.append(w.idx).append(" ");
        }
        System.out.println(sb.toString().trim());
	}
	
	public static class Work implements Comparable<Work> {
		int idx;
		int T;
		int S;
		double eff;
		
		public Work(int idx, int T, int S) {
			this.idx = idx;
			this.T = T;
			this.S = S;
		}
		
		public void calc() {
			this.eff = (double) this.S / this.T;
		}

		@Override
		public int compareTo(Work o) {
			if(o.eff == this.eff) {
				return this.idx - o.idx;
			}
			return Double.compare(o.eff, this.eff);
		}
	}
}