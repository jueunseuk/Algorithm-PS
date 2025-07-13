package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_11558_TheGameOfDeath {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0 ; t < T; t++) {
	        int n = Integer.parseInt(br.readLine());
	        
	        int[] arr = new int[n+1];
	        for (int i = 1; i <= n; i++) {
	            arr[i] = Integer.parseInt(br.readLine());
	        }
	        
	        System.out.println(bfs(n, n, arr));
        }
    }
    
    private static int bfs(int n, int k, int[] arr) {
        boolean[] visited = new boolean[n+1];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{1, 0});
        visited[1] = true;
        
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
        
        return 0;
    }
}
