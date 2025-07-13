package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2346_풍선터뜨리기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Deque<Pair> dq = new ArrayDeque<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) {
        	dq.addLast(new Pair(i, Integer.parseInt(st.nextToken())));
        }
        
        StringBuilder sb = new StringBuilder();
        Pair poll = dq.pollFirst();
        sb.append(poll.idx+" ");
        for(int i = 0; i < n-1; i++) {
        	if(poll.num > 0) {
        		while(--poll.num > 0) {
        			dq.addLast(dq.pollFirst());
        		}
        	} else {
        		while(poll.num++ < 0) {
        			dq.addFirst(dq.pollLast());
        		}
        	}
        	poll = dq.pollFirst();
        	sb.append(poll.idx+" ");
        }

        System.out.println(sb.toString().trim());
	}
	
	static public class Pair {
		int idx, num;

		public Pair(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
	}
}