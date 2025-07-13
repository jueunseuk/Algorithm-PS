package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_6195_FenceRepair {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0; i < n; i++) {
        	q.add(Integer.parseInt(br.readLine()));
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
