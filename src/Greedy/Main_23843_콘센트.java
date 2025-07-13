package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23843_콘센트 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        List<Long> list = new ArrayList<>();
        Queue<Long> q = new PriorityQueue<>();
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	list.add(Long.parseLong(st.nextToken()));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        for(int i = 0; i < n; i++) {
        	if(q.size() < k) {
        		q.offer(list.get(i));
        	} else {
        		q.offer(q.poll()+list.get(i));
        	}
        }
        
		while(q.size() != 1) {
			q.poll();
		}
        
        System.out.println(q.poll());
	}

}
