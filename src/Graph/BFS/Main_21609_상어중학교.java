package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21609_상어중학교 {
	static int size, m, score = 0;
	static int[][] matrix;
	static List<Group> groupList;
	static boolean[][] visit;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		size = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		matrix = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			List<Group> groupList = findGroup();
			
			if(groupList.isEmpty()) break;
			
			Collections.sort(groupList);
			
			Group group = groupList.get(0);
			remove(group);
			
			gravity();
			
			rotation();
			
			gravity();
		}
		
		System.out.println(score);
	}

	private static void rotation() {
		int[][] copy = new int[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				copy[i][j] = matrix[i][j];
			}
		}
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				matrix[size - 1 - j][i] = copy[i][j];
			}
		}
	}

	private static void gravity() {
	    for (int col = 0; col < size; col++) {
	        int write = size - 1;
	        for (int row = size - 1; row >= 0; row--) {
	            if (matrix[row][col] == -1) {
	                write = row - 1;
	            } else if (matrix[row][col] >= 0) {
	                if (row != write) {
	                    matrix[write][col] = matrix[row][col];
	                    matrix[row][col] = -2;
	                }
	                write--;
	            }
	        }
	    }
	}

	private static void remove(Group group) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean visit[][] = new boolean[size][size];
		
		q.offer(new int[] {group.standardX, group.standardY});
		visit[group.standardX][group.standardY] = true;
		matrix[group.standardX][group.standardY] = -2;
		
		int cnt = 1;
		int target = group.idx;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(outOfRange(nx, ny) || visit[nx][ny] || matrix[nx][ny] < 0) continue;
				
				if(matrix[nx][ny] == target || matrix[nx][ny] == 0) {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
					matrix[nx][ny] = -2;
					cnt++;
				}
			}
		}
		
		score += cnt*cnt;
	}

	private static List<Group> findGroup() {
		groupList = new ArrayList<>();
		visit = new boolean[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(!visit[i][j] && matrix[i][j] > 0) {
					simpleBfs(i, j);
				}
			}
		}
		
		return groupList;
	}

	private static void simpleBfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		
		List<int[]> rainbow = new ArrayList<>();
		int target = matrix[i][j];
		int cnt = 1;
		int standardX = i;
		int standardY = j;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(outOfRange(nx, ny) || visit[nx][ny] || matrix[nx][ny] < 0) continue;
				
				if(matrix[nx][ny] == target || matrix[nx][ny] == 0) {
					if(matrix[nx][ny] == 0) {
						rainbow.add(new int[] {nx, ny});
					} else {
						if(nx < standardX || (nx == standardX && ny < standardY)) {
						    standardX = nx;
						    standardY = ny;
						}
					}
					
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
					cnt++;
				}
			}
		}
		
		for(int[] out : rainbow) {
			visit[out[0]][out[1]] = false;
		}
		
		if(cnt > 1) {
			groupList.add(new Group(target, cnt, rainbow.size(), standardX, standardY));
		}
	}

	private static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= size || ny >= size;
	}
	
	static class Group implements Comparable<Group> {
		int idx, cnt, rainbowCnt, standardX, standardY;

		public Group(int idx, int cnt, int rainbowCnt, int standardX, int standardY) {
			this.idx = idx;
			this.cnt = cnt;
			this.rainbowCnt = rainbowCnt;
			this.standardX = standardX;
			this.standardY = standardY;
		}

		@Override
		public int compareTo(Group o) {
			if(this.cnt == o.cnt) {
				if(this.rainbowCnt == o.rainbowCnt) {
					if(this.standardX == o.standardX) {
						return o.standardY - this.standardY;
					}
					return o.standardX - this.standardX;
				}
				return o.rainbowCnt - this.rainbowCnt;
			}
			return o.cnt - this.cnt;
		}
	}
}