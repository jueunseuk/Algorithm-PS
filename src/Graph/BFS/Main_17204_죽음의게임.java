package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17204_죽음의게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(bfs(n, k, arr));
    }
    
    private static int bfs(int n, int k, int[] arr) {
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0, 0});
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int student = current[0];
            int steps = current[1];
            
            if (student == k) {
                return steps;
            }
            
            int next = arr[student];
            if (!visited[next]) {
                visited[next] = true;
                queue.add(new int[]{next, steps + 1});
            }
        }
        
        return -1;
    }
}
