package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Main_27440_1로만들기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long x = Long.parseLong(br.readLine());
        
        System.out.println(bfs(x));
    }

    static long bfs(long start) {
        if (start == 1) return 0;

        Queue<Long> q = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);

        long depth = 0;
        while (!q.isEmpty()) {
            long size = q.size();
            
            for (int i = 0; i < size; i++) {
                long curr = q.poll();
                
                if (curr == 1) {
                    return depth;
                }
                
                if (curr % 3 == 0) {
                    long next = curr / 3;
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
                
                if (curr % 2 == 0) {
                    long next = curr / 2;
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
                
                if (curr > 1) {
                    long next = curr - 1;
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
            depth++;
        }

        return -1;
    }
}
