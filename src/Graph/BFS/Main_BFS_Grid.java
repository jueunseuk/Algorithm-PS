package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BFS_Grid {
	static int row, col;
	static int matrix[][];
	static boolean visit[][];
	
	// 4방향으로 탐색하기 위한 x와 y의 delta 값
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 2차원 격자의 높이, 너비 저장
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		// 2차원 배열 및 방문 배열 초기화
		// 2차원 배열이므로 방문 배열도 2차원 형태로 선언
		matrix = new int[row][col];
		visit = new boolean[row][col];
		
		// 2차원 배열 저장
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 탐색을 시작할 위치와 목표 위치 저장
		st = new StringTokenizer(br.readLine(), " ");
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		// 탐색 시작
		int result = bfs(x1, y1, x2, y2);
		
		// 출력
		System.out.println(result);
	}

	private static int bfs(int x1, int y1, int x2, int y2) {
		Queue<int[]> q = new ArrayDeque<>();
		
		// 노드의 위치가 2차원 좌표로 저장되어있기 때문에 x 좌표, y 좌표, 거리 순으로 저장해야 함
		q.offer(new int[] {x1, y1, 0});
		visit[x1][y1] = true;
		
		while(!q.isEmpty()) { // 큐가 빌 때까지 반복
			// 큐에 있는 노드 추출
			int[] poll = q.poll();
			
			// 목표에 도달한 경우 거리 반환
			if(poll[0] == x2 && poll[1] == y2) {
				return poll[2]; // 3번째 위치에 있음을 주의
			}
			
			// 현재 노드의 위치에서 4 방향으로 탐색하면서 좌표값 계싼
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				// 상하좌우로 새로 이동한 좌표가 2차원 배열의 범위를 벗어나는 지 체크하고
				// 방문한 적이 있는 지 체크
				if(nx >= 0 && nx < row && ny >= 0 && ny < col && !visit[nx][ny] && matrix[nx][ny] == 0) {
					// 방문한 적이 없는 노드의 위치에 대해 큐에 추가
					// 거리는 현재 노드까지 오는 거리+1 값
					q.offer(new int[] {nx, ny, poll[2]+1});
					
					// 방문 처리
					visit[nx][ny] = true;
				}
			}
		}
		
		// 도달하지 못한 경우
		return -1;
	}
}