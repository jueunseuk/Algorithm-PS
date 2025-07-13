package Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1967_트리의지름 {
    static int N;
    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDistance, maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int from, to, dist;;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            
            while(true) {
            	to = Integer.parseInt(st.nextToken());
            	
            	if(to == -1) {
            		break;
            	}
            	
            	dist = Integer.parseInt(st.nextToken());
            	
	            tree[from].add(new Node(to, dist));
	            tree[to].add(new Node(from, dist));
            }
        }

        visited = new boolean[N+1];
        maxDistance = 0;
        dfs(1, 0);
        int A = maxNode;

        visited = new boolean[N+1];
        maxDistance = 0;
        dfs(A, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int current, int dist) {
        visited[current] = true;
        if(dist > maxDistance){
            maxDistance = dist;
            maxNode = current;
        }
        for(Node next : tree[current]){
            if(!visited[next.idx]) {
                dfs(next.idx, dist + next.dist);
            }
        }
    }

    static class Node {
        int idx, dist;
        public Node(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
    }
}
