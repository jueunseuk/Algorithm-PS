package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2234_성곽 {
	static int row, col, max = 0, room = 0, sumMax = 0;
	static Section[][] matrix;
	static boolean[][] visit;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        
        matrix = new Section[row][col];
        visit = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine() , " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = new Section(i, j, Integer.parseInt(st.nextToken()));
        	}
        }
        
        int idx = 0;
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(!visit[i][j]) {
        			bfs(i, j, idx++);
        			room++;
        		}
        	}
        }
        
        findMaxSumArea();
        
        System.out.println(room);
        System.out.println(max);
        System.out.println(sumMax);
	}
	
	private static void findMaxSumArea() {
		for(int i = 0; i < row-1; i++) {
			for(int j = 0; j < col; j++) {
				if(matrix[i][j].idx != matrix[i+1][j].idx) {
					sumMax = Math.max(sumMax, matrix[i][j].area+matrix[i+1][j].area);
				}
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col-1; j++) {
				if(matrix[i][j].idx != matrix[i][j+1].idx) {
					sumMax = Math.max(sumMax, matrix[i][j].area+matrix[i][j+1].area);
				}
			}
		}
	}

	private static void bfs(int i, int j, int idx) {
		Queue<int[]> q = new ArrayDeque<>();
		List<int[]> list = new ArrayList<>();
		
		q.offer(new int[] {i, j});
		list.add(new int[] {i, j});
		visit[i][j] = true;
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny]) {
					switch(delta) {
						case 0: {
							if(!matrix[poll[0]][poll[1]].s) {
								q.offer(new int[] {nx, ny});
								list.add(new int[] {nx, ny});
								visit[nx][ny] = true;
								cnt++;
							}
							break;
						}
						case 1: {
							if(!matrix[poll[0]][poll[1]].n) {
								q.offer(new int[] {nx, ny});
								list.add(new int[] {nx, ny});
								visit[nx][ny] = true;
								cnt++;
							}
							break;
						}
						case 2: {
							if(!matrix[poll[0]][poll[1]].e) {
								q.offer(new int[] {nx, ny});
								list.add(new int[] {nx, ny});
								visit[nx][ny] = true;
								cnt++;
							}
							break;
						}
						case 3: {
							if(!matrix[poll[0]][poll[1]].w) {
								q.offer(new int[] {nx, ny});
								list.add(new int[] {nx, ny});
								visit[nx][ny] = true;
								cnt++;
							}
							break;
						}
					}
				}
			}
		}
		
		max = Math.max(max, cnt);
		
		for(int[] out : list) {
			matrix[out[0]][out[1]].setArea(cnt, idx);;
		}
	}

	public static class Section {
		int x, y, idx, area;
		boolean w, e, n, s;
		
		public Section(int x, int y, int info) {
			this.x = x;
			this.y = y;
			w = ((info >> 0) & 1) == 1;
			n = ((info >> 1) & 1) == 1;
			e = ((info >> 2) & 1) == 1;
			s = ((info >> 3) & 1) == 1;
			area = 0;
			idx = 0;
		}
		
		public void setArea(int area, int idx) {
			this.area = area;
			this.idx = idx;
		}
	}
}