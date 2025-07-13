package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2696_중앙값구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = null;

            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();

            sb.append((n + 1) / 2).append("\n");

            int count = 0;

            for (int i = 0; i < n; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine(), " ");
                }

                int number = Integer.parseInt(st.nextToken());

                if (left.isEmpty() || number <= left.peek()) {
                    left.add(number);
                } else {
                    right.add(number);
                }

                if (left.size() > right.size() + 1) {
                    right.add(left.poll());
                } else if (right.size() > left.size()) {
                    left.add(right.poll());
                }

                if (i % 2 == 0) {
                    sb.append(left.peek()).append(" ");
                    count++;
                    if (count == 10) {
                        sb.append("\n");
                        count = 0;
                    }
                }
            }

            if (count > 0) {
                sb.append("\n");
            }
        }

        System.out.print(sb.toString().trim());
    }
}
