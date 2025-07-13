package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18149_LengthOfBundleRope {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int t = 0; t < T; t++) {
        	int n = Integer.parseInt(br.readLine());
        	
	        Queue<Integer> q = new PriorityQueue<>();
	        
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int i = 0; i < n; i++) {
	        	q.add(Integer.parseInt(st.nextToken()));
	        }
	        
	        long result = 0;
	        while(q.size() > 1) {
	        	int poll = q.poll()+q.poll();
	        	result += poll;
	        	q.add(poll);
	        }
	        
	        System.out.println(result);
        }
	}

}
