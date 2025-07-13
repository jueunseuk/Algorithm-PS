package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1374_강의실 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Table[] table = new Table[n];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	st.nextToken();
        	table[i] = new Table(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        br.close();
        
        Arrays.sort(table, new Comparator<Table>() {
			@Override
			public int compare(Table o1, Table o2) {
				if(o1.start == o2.start) {
					return o1.end - o2.end;
				}
				return o1.start - o2.start;
			}
		});
        
        Queue<Integer> q = new PriorityQueue<>();
        
        for(Table e : table) {
        	if(!q.isEmpty() && q.peek() <= e.start) {
        		q.poll();
        	}
        	q.add(e.end);
        }
        
        System.out.println(q.size());
	}

}

class Table {
	int start;
	int end;
	
	public Table(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
}