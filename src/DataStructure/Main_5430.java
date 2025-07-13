package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_5430 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String order = br.readLine();

            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            if (N > 0) {
                String[] elements = input.substring(1, input.length() - 1).split(",");
                for (String element : elements) {
                    deque.add(Integer.parseInt(element));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char cmd : order.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
        }
    }
}
