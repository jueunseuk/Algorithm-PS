package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11666_워크스테이션배정 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        
        Work[] works = new Work[n];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int stay = Integer.parseInt(st.nextToken());
        	
        	works[i] = new Work(start, start+stay);
        }
        
        Arrays.sort(works, new Comparator<Work>() {
			@Override
			public int compare(Work o1, Work o2) {
				if(o1.start == o2.start) {
					return o1.end - o2.end;
				}
				return o1.start - o2.start;
			}
        });
        
        Queue<Integer> q = new PriorityQueue<>();
        
        int cnt = 0;
        for (Work w : works) {
            int nowStart = w.start;
            int nowEnd = w.end;

            while (!q.isEmpty() && q.peek() + limit < nowStart) {
                q.poll();
            }

            if (!q.isEmpty() && q.peek() <= nowStart) {
                cnt++;
                q.poll();
            }

            q.add(nowEnd);
        }
        
        System.out.println(cnt);
	}

}

class Work {
	int start;
	int end;
	
	public Work(int start, int end) {
		this.start = start;
		this.end = end;
	}
}