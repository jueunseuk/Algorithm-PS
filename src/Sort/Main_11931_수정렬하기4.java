package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_11931_수정렬하기4 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
        });
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
        	q.offer(Integer.parseInt(br.readLine()));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
        	sb.append(q.poll()).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}