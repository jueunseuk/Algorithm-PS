package PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25827_시간구간다중업데이트 {
	static final int SEC = 86400;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int query = Integer.parseInt(br.readLine());
        
        int[] diff = new int[SEC+1];
        
        StringTokenizer st;
        
        int type = 0;
        String[] start = {};
        String[] end = {};
        int q = 0;
        for(; q < query; q++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	type = Integer.parseInt(st.nextToken());
        	start = st.nextToken().split(":");
        	end = st.nextToken().split(":");
        	
        	if(type == 2) {
        		break;
        	}
        	
        	int s = makeToSecond(start)+1;
        	int e = makeToSecond(end);
        	
        	diff[s]++;
        	diff[e+1]--;
        }
        
        for(int i = 1; i <= SEC; i++) {
        	diff[i] += diff[i-1];
        }
        
        for(int i = 1; i <= SEC; i++) {
        	diff[i] += diff[i-1];
        }
        
        int s = makeToSecond(start)+1;
        int e = makeToSecond(end);
        
        StringBuilder sb = new StringBuilder();
        sb.append(diff[e]-diff[s-1]).append("\n");
        
        for(; q < query-1; q++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	type = Integer.parseInt(st.nextToken());
        	start = st.nextToken().split(":");
        	end = st.nextToken().split(":");
        	
        	s = makeToSecond(start)+1;
        	e = makeToSecond(end);
        	
        	sb.append(diff[e]-diff[s-1]).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static int makeToSecond(String[] time) {
		return Integer.parseInt(time[0])*3600 + Integer.parseInt(time[1])*60 + Integer.parseInt(time[2]);
	}
}