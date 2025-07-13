package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1826_연료채우기 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Station[] stations = new Station[n+1];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	stations[i] = new Station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        stations[n] = new Station(Integer.parseInt(st.nextToken()), 0);
        int currentAmount = Integer.parseInt(st.nextToken());
        
        Arrays.sort(stations, new Comparator<Station>() {
			@Override
			public int compare(Station o1, Station o2) {
				if(o1.pos == o2.pos) {
					return o2.liter - o1.liter;
				}
				return o1.pos - o2.pos;
			}
        });
        
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        int cnt = 0;
        for(int i = 0 ; i < n; i++) {
    		q.offer(stations[i].liter);
        	
    		while(currentAmount < stations[i+1].pos) {
    			Integer poll = q.poll();
    			if(poll == null) {
    				System.out.println(-1);
    				return;
    			}
    			currentAmount += poll;
    			cnt++;
    		}
    		
    		if(currentAmount >= stations[n].pos) {
    			System.out.println(cnt);
    			return;
    		}
        }
        
        System.out.println(-1);
	}
}

class Station {
	int pos;
	int liter;
	
	public Station() {
		
	}
	
	public Station(int pos, int liter) {
		this.pos = pos;
		this.liter = liter;
	}
}