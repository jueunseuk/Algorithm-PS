package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_28703_DoubleIt {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        Queue<Integer> q = new PriorityQueue<>();

        int initialMax = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
        	int input = Integer.parseInt(st.nextToken()); 
        	q.add(input);
        	if(initialMax < input) {
        		initialMax = input;
        	}
        }
        
        int currentMax = initialMax;
        int minSub = currentMax - q.peek();
        while(q.peek() < initialMax) {
        	int poll = q.poll();
        	minSub = Math.min(currentMax - poll, minSub);
        	currentMax = Math.max(currentMax, poll << 1);
        	q.add(poll << 1);
        }
        
        System.out.println(Math.min(currentMax - q.peek(), minSub));
        
	}

}
