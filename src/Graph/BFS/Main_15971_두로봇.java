package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15971_두로봇 {
	static int n, m, a, b;
	static List<List<int[]>> list;
	static boolean[] visit;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken())-1;
        b = Integer.parseInt(st.nextToken())-1;
        m = n-1;

        list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            
            list.get(start).add(new int[] {end, cost});
            list.get(end).add(new int[] {start, cost});
        }
        
        bfs();
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        visit = new boolean[n];
        q.add(new int[] {a, 0, 0});
        visit[a] = true;
        
        while(!q.isEmpty()) {
        		int[] poll = q.poll();
        		
        		if(poll[0] == b) {
        			System.out.println(poll[1]-poll[2]);
        			return;
        		}
        		
        		for(int[] out : list.get(poll[0])) {
        			if(!visit[out[0]]) {
        				visit[out[0]] = true;
        				q.offer(new int[] {out[0], poll[1]+out[1], Math.max(out[1], poll[2])});
        			}
        		}
        }
    }
}