package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_1835_카드 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Deque<Integer> deq = new ArrayDeque<>();
                
        for (int i = n; i >= 1; i--) {
            deq.offerFirst(i);
            for (int k = 0; k < i; k++) {
                deq.offerFirst(deq.pollLast());
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        int size = deq.size();
        for(int i = 0; i < size; i++) {
        	sb.append(deq.pollFirst()+" ");
        }
        
        System.out.println(sb.toString().trim());
	}
}