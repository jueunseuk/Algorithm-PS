package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Dijkstra {
static final int INF = Integer.MAX_VALUE;
	
	static int size, edge, start;
	static List<List<int[]>> list = new ArrayList<>();
	static int[] cost; // 또는 dist
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        size = Integer.parseInt(st.nextToken()); // 노드의 수
        edge = Integer.parseInt(st.nextToken()); // 간선의 수
        start = Integer.parseInt(st.nextToken()); // 탐색을 시작하 정점
        
        cost = new int[size+1];
        for(int i = 0; i <= size; i++) {
        	Arrays.fill(cost, INF); // 비용 배열 초기화
        }
        
        for(int i = 0; i <= size; i++) {
        	list.add(new ArrayList<>()); // 인접 리스트 초기화
        }
        
        for(int i = 0; i < edge; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	list.get(s).add(new int[] {e, c});
        }
        
        dijkstra(start);
        
        for(int i = 1; i <= size; i++) {
        	System.out.println(i+" >> "+cost[i]);
        }
	}

	public static void dijkstra(int start) {
		// 우선순위 큐의 정렬 기준은 노드까지 필요한 가중치(최소 보장 X)
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		
		pq.offer(new int[] {start, 0});
		cost[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] poll = pq.poll();
			
			for(int[] out : list.get(poll[0])) {
				// cost[out[0]] : 인접한 노드로 이동하는 현재 최소 비용
				// poll[1] : 탐색 중 쌓인 가중치 = 비용
				// out[1] : 현재 노드에서 인접 노드로 이동하는 가중치 = 비용
				if(cost[out[0]] > poll[1] + out[1]) {
					cost[out[0]] = poll[1] + out[1];
					pq.offer(new int[] {out[0], poll[1]+out[1]});
				}
			}
		}
	}
}