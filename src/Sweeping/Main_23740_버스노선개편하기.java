package Sweeping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23740_버스노선개편하기 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        long[][] line = new long[n][3];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	line[i][0] = Integer.parseInt(st.nextToken());
        	line[i][1] = Integer.parseInt(st.nextToken());
        	line[i][2] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(line, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				if(o1[0] == o2[0]) {
					return Long.compare(o1[1], o2[1]);
				}
				return Long.compare(o1[0], o2[0]);
			}
        });
        
        int cnt = 1;
        Queue<long[]> q = new ArrayDeque<>();
        long start = line[0][0];
        long end = line[0][1];
        long cost = line[0][2];
        for(int i = 1; i < n; i++) {
        	if(line[i][0] > end) {
        		q.offer(new long[] {start, end, cost});
        		cnt++;
        		start = line[i][0];
        		end = line[i][1];
        		cost = line[i][2];
        	} else {
        		end = Math.max(end, line[i][1]);
        		cost = Math.min(cost, line[i][2]);
        	}
        }
        q.offer(new long[] {start, end, cost});
        
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        while(!q.isEmpty()) {
        	sb.append(q.peek()[0]).append(" ").append(q.peek()[1]).append(" ").append(q.peek()[2]).append("\n");
        	q.poll();
        }
        
        System.out.println(sb.toString().trim());
	}
}