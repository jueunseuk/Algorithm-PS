package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15235_OlympiadPizza {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Queue<Player> q = new ArrayDeque<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) {
        	q.offer(new Player(i, Integer.parseInt(st.nextToken())));
        }
        
        int time = 1;
        int[] result = new int[n+1];
        
        while(!q.isEmpty()) {
        	if(q.peek().need == 1) {
        		result[q.peek().idx] = time;
        	} else {
        		q.offer(new Player(q.peek().idx, q.peek().need-1));
        	}
        	time++;
        	q.poll();
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
        	sb.append(result[i]+" ");
        }
        
        System.out.println(sb.toString().trim());
	}

	static class Player {
		int idx, need;

		public Player(int idx, int need) {
			this.idx = idx;
			this.need = need;
		}
	}
}