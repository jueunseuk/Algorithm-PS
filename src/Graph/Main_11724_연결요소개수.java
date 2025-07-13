package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11724_연결요소개수 {
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;

    // DFS 함수
    static void dfs(int v) {
        visited[v] = true; // 현재 노드 방문 처리
        for (int neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                dfs(neighbor); // 방문하지 않은 이웃 노드에 대해 DFS
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        adjList = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
        	adjList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	adjList[a].add(b);
        	adjList[b].add(a);
        }
        
        int cnt = 0;
        visited = new boolean[N+1];
        
        for(int i = 1; i <= N; i++) {
        	if(!visited[i]) {
        		dfs(i);
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
    }
}
