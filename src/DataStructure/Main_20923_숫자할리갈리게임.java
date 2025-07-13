package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_20923_숫자할리갈리게임 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Deque<Integer> deqDo = new ArrayDeque<>();
        Deque<Integer> deqSu = new ArrayDeque<>();
        Deque<Integer> groundDo = new ArrayDeque<>();
        Deque<Integer> groundSu = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	deqDo.offerFirst(Integer.parseInt(st.nextToken()));
        	deqSu.offerFirst(Integer.parseInt(st.nextToken()));
        }
        
        for(int i = 0; i < k; i++) {
        	if(i % 2 == 0) {
        		groundDo.offerFirst(deqDo.pollFirst());
        	} else {
        		groundSu.offerFirst(deqSu.pollFirst());
        	}
        	
        	if(deqSu.isEmpty()) {
        		System.out.println("do");
        		return;
        	} else if(deqDo.isEmpty()) {
        		System.out.println("su");
        		return;
        	}
        	
        	if((!groundDo.isEmpty() && groundDo.peekFirst() == 5) || (!groundSu.isEmpty() && groundSu.peekFirst() == 5)) {
        		int doSize = groundDo.size();
        		int suSize = groundSu.size();
        		
        		for(int j = 0; j < suSize; j++) {
        			deqDo.offerLast(groundSu.pollLast());
        		}
        		for(int j = 0; j < doSize; j++) {
        			deqDo.offerLast(groundDo.pollLast());
        		}
        	} else if(!groundDo.isEmpty() && !groundSu.isEmpty() && groundDo.peekFirst() + groundSu.peekFirst() == 5) {
        		int doSize = groundDo.size();
        		int suSize = groundSu.size();
        		
        		for(int j = 0; j < doSize; j++) {
        			deqSu.offerLast(groundDo.pollLast());
        		}
        		for(int j = 0; j < suSize; j++) {
        			deqSu.offerLast(groundSu.pollLast());
        		}
        	}
        	
        	if(deqSu.isEmpty()) {
        		System.out.println("do");
        		return;
        	} else if(deqDo.isEmpty()) {
        		System.out.println("su");
        		return;
        	}
        }
        
        if(deqDo.size() == deqSu.size()) {
        	System.out.println("dosu");
        } else if(deqDo.size() > deqSu.size()) {
        	System.out.println("do");
        } else {
        	System.out.println("su");
        }

	}
}