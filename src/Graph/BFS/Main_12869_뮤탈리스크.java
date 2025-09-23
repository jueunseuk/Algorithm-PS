package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12869_뮤탈리스크 {
	static final int MAX = 70;
	static int n, first, second, third;
	
	static int[] dx = {9, 3, 1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        first = Integer.parseInt(st.nextToken());
        if(n >= 2) second = Integer.parseInt(st.nextToken());
        if(n >= 3) third = Integer.parseInt(st.nextToken());
        
        switch(n) {
	        case 1: {
	        	one();
	        	break;
	        }
	        case 2: {
	        	two();
	        	break;
	        }
	        case 3: {
	        	three();
	        	break;
	        }
        }
	}

	private static void three() {
	    Queue<int[]> q = new ArrayDeque<>();
	    boolean[][][] visit = new boolean[MAX][MAX][MAX];

	    q.offer(new int[] {first, second, third, 0});
	    visit[first][second][third] = true;

	    while (!q.isEmpty()) {
	        int[] poll = q.poll();

	        if (poll[0] <= 0 && poll[1] <= 0 && poll[2] <= 0) {
	            System.out.println(poll[3]);
	            return;
	        }

	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (i == j) continue;
	                for (int k = 0; k < 3; k++) {
	                    if (j == k || i == k) continue;

	                    int ni = Math.max(0, poll[0] - dx[i]);
	                    int nj = Math.max(0, poll[1] - dx[j]);
	                    int nk = Math.max(0, poll[2] - dx[k]);

	                    if (!visit[ni][nj][nk]) {
	                        q.offer(new int[] {ni, nj, nk, poll[3] + 1});
	                        visit[ni][nj][nk] = true;
	                    }
	                }
	            }
	        }
	    }
	}


	private static void two() {
	    Queue<int[]> q = new ArrayDeque<>();
	    boolean[][] visit = new boolean[MAX][MAX];

	    q.offer(new int[] {first, second, 0});
	    visit[first][second] = true;

	    while (!q.isEmpty()) {
	        int[] poll = q.poll();

	        if (poll[0] <= 0 && poll[1] <= 0) {
	            System.out.println(poll[2]);
	            return;
	        }

	        for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < 2; j++) {
	                if (i == j) continue;

	                int ni = Math.max(0, poll[0] - dx[i]);
	                int nj = Math.max(0, poll[1] - dx[j]);

	                if (!visit[ni][nj]) {
	                    q.offer(new int[] {ni, nj, poll[2] + 1});
	                    visit[ni][nj] = true;
	                }
	            }
	        }
	    }
	}


	private static void one() {
		System.out.println(first%9 == 0 ? first/9 : first/9+1);
	}
}
