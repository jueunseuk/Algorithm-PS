package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2014_소수의곱 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        long input[] = new long[n];
        
        Queue<Long>	q = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
        	input[i] = Long.parseLong(st.nextToken());
        	q.offer(input[i]);
        	set.add(input[i]);
        }
        
        Arrays.sort(input);
        
        long answer = 0;
        for(int i = 0; i < k; i++) {
        	answer = q.poll();
        	
        	for(long out : input) {
        		long next = answer * out;
        		
        		if(next >= Integer.MAX_VALUE) {
        			break;
        		}
        		
        		if(!set.contains(next)) {
        			set.add(next);
        			q.offer(next);
        		}
        		
        		if(answer % out == 0) {
        			break;
        		}
        	}
        }
        
        System.out.println(answer);
	}
}
