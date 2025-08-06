package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BFS_General {
	static int size, edge;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 그래프의 노드, 간선 수 저장
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		size = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		
		// 방문 배열 및 인접 리스트 초기화
		// 1번 노드부터 size번 노드까지 존재하기 때문에 size+1만큼 초기화
		visit = new boolean[size+1];
		for(int i = 0; i <= size; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 양방향 그래프인 경우 인접 리스트에 아래처럼 간선 추가
			list.get(start).add(end);
			list.get(end).add(start);
		}
		
		// 1번 노드부터 시작해서 9번 노드까지의 최단 거리
		int result= bfs(1, 9);
		
		// 출력
		System.out.println(result);
	}

	private static int bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		
		// 탐색을 시작할 노드를 추가하고 현재 노드까지의 거리를 0으로 저장
		q.offer(new int[] {i, 0});
		// 방문 배열 갱신
		visit[i] = true;
		
		while(!q.isEmpty()) { // 큐가 빌 때까지 반복
			// 큐에 들어있는 노드 추출
			int[] poll = q.poll();
			
			// 목표에 도달한 경우 거리 반환
			if(poll[0] == j) {
				return poll[1];
			}
			
			for(int search : list.get(poll[0])) { // 추출한 노드의 인접한 노드들 전부 방문
				if(!visit[search]) { // 방문하지 않은 노드만 큐에 추가
					// 방문하지 않았던 큐를 추가하되, 거리는 현재의 +1만큼 추가
					q.offer(new int[] {search, poll[1]+1});
					
					// 방문 처리
					visit[search] = true;
				}
			}
		}
		// 간선이 없어 도달 불가한 경우
		return -1;
	}
	
}