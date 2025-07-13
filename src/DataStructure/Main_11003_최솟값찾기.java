package DataStructure;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_11003_최솟값찾기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        ArrayDeque<int[]> window = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (!window.isEmpty() && window.peekFirst()[0] <= i - L) {
                window.pollFirst();
            }

            while (!window.isEmpty() && window.peekLast()[1] > now) {
                window.pollLast();
            }

            window.addLast(new int[]{i, now});

            bw.write(window.peekFirst()[1] + " ");
        }

        bw.flush();
        bw.close();
    }
}
