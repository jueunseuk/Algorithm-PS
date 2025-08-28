package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16235_나무재테크 {
	static int n, m, K;
	static Section[][] matrix;
	
	static final int dx[] = {-1,-1,-1, 0,0, 1,1,1};
	static final int dy[] = {-1, 0, 1,-1,1,-1,0,1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        matrix = new Section[n][n];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < n; j++) {
        		matrix[i][j] = new Section(i, j, 5, Integer.parseInt(st.nextToken()));
        	}
        }

        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int x = Integer.parseInt(st.nextToken())-1;
        	int y = Integer.parseInt(st.nextToken())-1;
        	int z = Integer.parseInt(st.nextToken());
        	
        	matrix[x][y].trees.add(z);
        }
        
        for(int k = 0; k < K; k++) {
        	Queue<Section> q = new ArrayDeque<>(); // for spring
        	
        	// spring
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			if(!matrix[i][j].trees.isEmpty()) {
        				q.offer(matrix[i][j]);
        			}
        		}
        	}
        	
        	while(!q.isEmpty()) {
        		Section poll = q.poll();
        		
        		int surplus = 0;
        		int treeCnt = poll.trees.size();
        		for(int i = 0; i < treeCnt; i++) {
        			int t = poll.trees.get(0);
        			if(t <= poll.cnut) {
        				poll.trees.add(t+1);
        				poll.cnut -= t;
        			} else {
        				surplus += t / 2;
        			}
        			
        			poll.trees.remove(0);
        		}
        		
        		// summer
        		poll.cnut += surplus;
        	}
        	
        	// fall
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			for(int out : matrix[i][j].trees) {
        				if(out % 5 == 0) {
        					makeTree(i, j, out);
        				}
        			}
        		}
        	}
        	
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			if(matrix[i][j].trees.size() > 0) {
        				matrix[i][j].treeSort();
        			}
        		}
        	}
        	
        	// winter
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			matrix[i][j].cnut += matrix[i][j].pnut;
        		}
        	}
        }
        
        int result = 0;
        for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			result += matrix[i][j].trees.size();
    		}
    	}
        
        System.out.println(result);
	}
	
	private static void makeTree(int i, int j, int out) {
		for(int delta = 0; delta < 8; delta++) {
			int nx = i + dx[delta];
			int ny = j + dy[delta];
			
			if(outOfRange(nx, ny)) continue;
			
			matrix[nx][ny].trees.add(1);
		}
	}

	public static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= n;
	}

	static class Section {
		int x, y, cnut, pnut;
		List<Integer> trees;
		
		public Section(int x, int y, int cnut, int pnut) {
			this.x = x;
			this.y = y;
			this.cnut = cnut;
			this.pnut = pnut;
			this.trees = new ArrayList<>();
		}
		
		public void treeSort() {
			Collections.sort(trees);
		}
	}
}