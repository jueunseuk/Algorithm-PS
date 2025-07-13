package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_20301_반전요세푸스 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
        	dq.offerLast(i);
        }
        
        boolean dir = true;
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) {
        	if(dir) {
        		for(int i = 0; i < k-1; i++) {
        			dq.offerLast(dq.pollFirst());
        		}
        		sb.append(dq.pollFirst()+"\n");
        	} else {
        		for(int i = 0; i < k-1; i++) {
        			dq.offerFirst(dq.pollLast());
        		}
        		sb.append(dq.pollLast()+"\n");
        	}
        	
        	if((n-dq.size()) % m == 0) {
        		dir = !dir;
        	}
        }
        
        System.out.println(sb.toString().trim());
	}
}