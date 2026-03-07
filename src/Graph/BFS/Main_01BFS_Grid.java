package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_01BFS_Grid {
	static final int INF = 100000000;
	
	static int row, col;
    static int[][] matrix;
    static int cost[][];
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken()); // 행
        col = Integer.parseInt(st.nextToken()); // 열
        
        // 배열 초기화
        matrix = new int[row][col];
        cost = new int[row][col];
        for(int i = 0; i < row; i++) {
        	// 비용 배열 무한대로 초기화
        	Arrays.fill(cost[i], INF);
        	
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // 출발 지점 입력
        st = new StringTokenizer(br.readLine(), " ");
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        
        zobfs(sx, sy);
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		sb.append(cost[i][j]);
        		if(j < col-1) sb.append(" ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void zobfs(int x1, int y1) {
		Deque<int[]> deq = new ArrayDeque<>();
		
		deq.offer(new int[] {x1, y1, 0});
		cost[x1][y1] = 0;
		
		while(!deq.isEmpty()) {
			int[] poll = deq.poll();
			
			// 상하좌우 탐색
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				// 범위 체크 및 비용 감소 체크
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && cost[nx][ny] > poll[2] + matrix[nx][ny]) {
					if(matrix[nx][ny] == 0) {
						deq.offerFirst(new int[] {nx, ny, poll[2]});
						cost[nx][ny] = poll[2];
					} else {
						// matrix[nx][ny] == 1이면 몬스터 존재하므로 비용 1 증가
						deq.offerLast(new int[] {nx, ny, poll[2]+1});
						cost[nx][ny] = poll[2] + 1;
					}
				}
			}
		}
	}
}