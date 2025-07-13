package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_2161_카드1 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 1; i <= n; i++) {
        	q.offer(i);
        }
        
        StringBuilder sb = new StringBuilder();
        while(n-- > 1) {
        	sb.append(q.poll()).append(" ");
        	q.offer(q.poll());
        }
        
        sb.append(q.poll());
        
        System.out.println(sb.toString().trim());
	}
}