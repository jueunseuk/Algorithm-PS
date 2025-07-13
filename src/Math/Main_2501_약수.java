package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2501_약수 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int origin = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 1; i <= origin && q.size() < k; i++) {
        	if(origin % i == 0) q.add(i);
        }
        
        System.out.println(q.size() < k ? 0 : q.poll());
        
	}
}
