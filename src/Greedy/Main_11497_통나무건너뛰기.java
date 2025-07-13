package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_11497_통나무건너뛰기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
        	int n = Integer.parseInt(br.readLine());
        	
        	int input[] = new int[n];
        	
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	for(int i = 0; i < n; i++) {
        		input[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	Arrays.sort(input);
        	
        	Deque<Integer> dq = new ArrayDeque<>();
        	dq.add(input[0]);
        	
        	int maxSub = 0;
        	for(int i = 1; i < n; i++) {
        		if(i % 2 == 0) {
        			maxSub = Math.max(maxSub, input[i]-dq.peekFirst());
        			dq.addFirst(input[i]);
        		} else {
        			maxSub = Math.max(maxSub, input[i]-dq.peekLast());
        			dq.addLast(input[i]);
        		}
        	}
        	
        	System.out.println(maxSub);
        }
	}

}
