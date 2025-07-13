package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1021_회전하는큐 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int target[] = new int[k];
        for (int i = 0; i < k; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        int result = 0;
        for (int i = 0; i < k; i++) {
        	int leftRotation = 0;
            int rightRotation = 0;

            while (q.peekFirst() != target[i]) {
                q.addLast(q.pollFirst());
                leftRotation++;
            }

            rightRotation = q.size() - leftRotation;

            q.pollFirst();

            result += Math.min(leftRotation, rightRotation);
        }

        System.out.println(result);
        br.close();
    }
}
