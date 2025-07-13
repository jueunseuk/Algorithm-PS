package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_24444 {
	static ArrayList<Integer>[] adjList;
	static int N, R, order = 1;
	static int[] visitOrder;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		int M = Integer.parseInt(st.nextToken()); // 간선 개수
		R = Integer.parseInt(st.nextToken()); // 시작점
		
		adjList = new ArrayList[N + 1];
		visitOrder = new int[N+1];
		order = 1;
		
		for(int i = 1; i<= N; i++) adjList[i] = new ArrayList<>(); // 이중 리스트 만들기
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		for(int i = 1; i <= N; i++) Collections.sort(adjList[i]);
		
		bfs();
		
		for(int i = 1; i <= N; i++) {
			System.out.println(visitOrder[i]);
		}
		
		br.close();
		
	}//main
	
	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean isVisited[] = new boolean[N+1];
		
		int current = R;
		q.add(current);
		
		while(!q.isEmpty()) {
			current = q.poll();
			
			if(isVisited[current])continue;
			
			
			isVisited[current] = true;
			visitOrder[current] = order++;
			
			for (int next : adjList[current]) {
	            if (!isVisited[next]) {
	                q.add(next);
	            }
	        }
		}
	}//bfs
}//class
