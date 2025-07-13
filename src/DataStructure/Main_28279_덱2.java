package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_28279_덱2 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Deque<Integer> deq = new ArrayDeque<>();
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	int order = Integer.parseInt(st.nextToken());
        	
        	switch(order) {
	        	case 1 : {
	        		deq.offerFirst(Integer.parseInt(st.nextToken()));
	        		break;
	        	}
	        	case 2 : {
	        		deq.offerLast(Integer.parseInt(st.nextToken()));
	        		break;
	        	}
	        	case 3 : {
	        		if(deq.isEmpty()) sb.append("-1");
	        		else sb.append(deq.pollFirst());
	        		sb.append("\n");
	        		break;
	        	}
	        	case 4 : {
	        		if(deq.isEmpty()) sb.append("-1");
	        		else sb.append(deq.pollLast());
	        		sb.append("\n");
	        		break;
	        	}
	        	case 5 : {
	        		sb.append(deq.size()).append("\n");
	        		break;
	        	}
	        	case 6 : {
	        		if(deq.isEmpty()) sb.append(1);
	        		else sb.append(0);
	        		sb.append("\n");
	        		break;
	        	}
	        	case 7 : {
	        		if(deq.isEmpty()) sb.append("-1");
	        		else sb.append(deq.peekFirst());
	        		sb.append("\n");
	        		break;
	        	}
	        	case 8 : {
	        		if(deq.isEmpty()) sb.append("-1");
	        		else sb.append(deq.peekLast());
	        		sb.append("\n");
	        		break;
	        	}
        	}
        }
        
        System.out.println(sb.toString().trim());

	}

}
