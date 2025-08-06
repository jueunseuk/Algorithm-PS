package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_14395_4연산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long target = Long.parseLong(st.nextToken());

        if (x == target) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs(x, target));
    }

    private static String bfs(long x, long target) {
        Queue<Node> q = new ArrayDeque<>();
        HashSet<Long> visited = new HashSet<>();

        q.offer(new Node(x, new StringBuilder()));
        visited.add(x);

        while (!q.isEmpty()) {
            Node poll = q.poll();
            long number = poll.number;
            StringBuilder sb = poll.input;

            if (number == target) {
                return sb.toString().trim();
            }

            if (number * number <= target && !visited.contains(number * number)) {
                visited.add(number * number);
                q.offer(new Node(number * number, new StringBuilder(sb).append("*")));
            }
            if (number + number <= target && !visited.contains(number + number)) {
                visited.add(number + number);
                q.offer(new Node(number + number, new StringBuilder(sb).append("+")));
            }
            if (!visited.contains(0L) && number != 0) {
                visited.add(0L);
                q.offer(new Node(0, new StringBuilder(sb).append("-")));
            }
            if (!visited.contains(1L) && number != 0) {
                visited.add(1L);
                q.offer(new Node(1, new StringBuilder(sb).append("/")));
            }
        }

        return "-1";
    }

    static class Node {
        long number;
        StringBuilder input;

        public Node(long number, StringBuilder input) {
            this.number = number;
            this.input = input;
        }
    }
}
