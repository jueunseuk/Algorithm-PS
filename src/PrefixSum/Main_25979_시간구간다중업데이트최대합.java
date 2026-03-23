package PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25979_시간구간다중업데이트최대합 {
	static final int SEC = 86400;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int query = Integer.parseInt(br.readLine());
        
        long[] diff = new long[SEC+1];
        
        StringTokenizer st;
        
        String[] start = {};
        String[] end = {};
        for(int q = 0; q < query-1; q++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	st.nextToken();
        	start = st.nextToken().split(":");
        	end = st.nextToken().split(":");
        	
        	int s = makeToSecond(start)+1;
        	int e = makeToSecond(end);
        	
        	diff[s]++;
        	diff[e+1]--;
        }
        
        for(int i = 1; i <= SEC; i++) {
        	diff[i] += diff[i-1];
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        st.nextToken();
        String[] period = st.nextToken().split(":");
        int p = makeToSecond(period);
        
        long curr = 0;
        for(int i = 1; i <= p; i++) {
        	curr += diff[i];
        }
        
        long max = curr;
        int left = 1;
        int right = p + 1;
        while (right <= SEC) {
            curr += diff[right++];
            curr -= diff[left++];

            if (max < curr) {
                max = curr;
            }
        }
        
        System.out.println(max);
	}

	private static int makeToSecond(String[] time) {
		return Integer.parseInt(time[0])*3600 + Integer.parseInt(time[1])*60 + Integer.parseInt(time[2]);
	}
}