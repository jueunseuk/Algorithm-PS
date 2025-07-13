package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1966_프린터큐 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            LinkedList<int[]> queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new int[] {priority, i});
            }

            int count = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                boolean hasHigherPriority = false;

                for (int[] doc : queue) {
                    if (doc[0] > current[0]) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    queue.offer(current);
                } else {
                    count++;
                    if (current[1] == M) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}
