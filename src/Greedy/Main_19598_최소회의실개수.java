package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19598_최소회의실개수 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Room[] room = new Room[n];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	room[i] = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        br.close();
        
        Arrays.sort(room, new Comparator<Room>() {
			@Override
			public int compare(Room o1, Room o2) {
				if(o1.start == o2.start) {
					return o1.end - o2.end;
				}
				return o1.start - o2.start;
			}
		});
        
        Queue<Integer> q = new PriorityQueue<>();
        
        for(Room e : room) {
        	if(!q.isEmpty() && q.peek() <= e.start) {
        		q.poll();
        	}
        	q.add(e.end);
        }
        
        System.out.println(q.size());
	}

}

class Room {
	int start;
	int end;
	
	public Room(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
}