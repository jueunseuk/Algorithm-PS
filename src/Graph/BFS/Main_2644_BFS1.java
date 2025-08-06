package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644_BFS1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //사람 수 입력
		
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int target1 = Integer.parseInt(st.nextToken()); // 타겟1
        int target2 = Integer.parseInt(st.nextToken()); // 타겟2
        
        int relation = Integer.parseInt(br.readLine()); // 관계 수
        
        List<List<Integer>> list = new ArrayList<>();
        // 사람 수만큼 list 초기화
        for(int i = 0; i <= N; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < relation; i++) {
        	st = new StringTokenizer(br.readLine(), " ");        
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	list.get(start).add(end);
        	list.get(end).add(start);
        }
        
        int result = bfs(list, target1, target2);
        
        System.out.println(result);
        
	}

	private static int bfs(List<List<Integer>> list, int target1, int target2) {
		boolean[] isVisited = new boolean[list.size()];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {target1, 0}); // 배열은 각각 현재 노드와 현재 노드까지의 거리를 의미
		isVisited[target1] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentNode = current[0];
			int currentDistance = current[1];
			
			// 현재 노드와 목표2가 일치할 때 배열의 1인덱스 출력
			if(currentNode == target2) return currentDistance;
			
			// 우선 currentNode의 이웃 노드를 전부 temp로 가져옴
			for(int temp : list.get(currentNode)) {
				// 가져온 각 이웃 노드들에 대해 방문하지 않은 곳이라면 실행
				if(!isVisited[temp]) {
					// 방문 처리 후
					isVisited[temp] = true;
					// temp 노드를 큐에 추가, 하나의 촌수를 지났기 때문에 currentDistance는 1 증가
					// 지금 추가된 노드들은 추후 while문에 의해 탐색됨
					queue.add(new int[] {temp, currentDistance+1});
				}
			}
		}
		
		return -1;
	}

}
