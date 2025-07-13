package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1379_강의실2 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Schedule[] schedule = new Schedule[n];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	schedule[i] = new Schedule(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
        }
        
        br.close();
        
        Arrays.sort(schedule, new Comparator<Schedule>() {
			@Override
			public int compare(Schedule o1, Schedule o2) {
				if(o1.start == o2.start) {
					return o1.end - o2.end;
				}
				return o1.start - o2.start;
			}
		});
        
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int result[] = new int[n+1];
        
        int room = 1;
        for(Schedule sch : schedule) {
        	if(!q.isEmpty() && sch.start >= q.peek()[1]) {
        		int[] poll = q.poll();
        		poll[1] = sch.end;
        		q.offer(poll);
        		result[sch.idx] = poll[0];
        	} else {
        		q.offer(new int[] {room, sch.end});
        		result[sch.idx] = room++;
        	}
        }
        
        System.out.println(q.size());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
        	sb.append(result[i]).append("\n");
        }
        System.out.println(sb.toString().trim());
	}

}

class Schedule {
	int idx;
	int start;
	int end;
	
	public Schedule(int idx, int start, int end) {
		this.idx = idx;
		this.start = start;
		this.end = end;
	}
}