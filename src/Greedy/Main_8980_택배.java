package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_8980_택배 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(br.readLine());
        
        Delivery[] deli = new Delivery[m];
        
        Arrays.sort(deli, new Comparator<Delivery>() {
			@Override
			public int compare(Delivery o1, Delivery o2) {
				if(o1.end == o2.end) {
					return o1.start - o2.start;
				}
				return o1.end - o2.end;
			}
        });
        
        for(int i = 0; i < m; i++) {
        	
        }
        
        
        
        
	}

	static class Delivery {
		int start;
		int end;
		int cnt;
		
		public Delivery(int start, int end, int cnt) {
			super();
			this.start = start;
			this.end = end;
			this.cnt = cnt;
		}
	}
}
