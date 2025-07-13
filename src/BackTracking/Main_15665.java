package BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_15665 {
    static int N, R;
    static int[] input;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        input = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        result = new int[R];

        recur(0);

        System.out.print(sb.toString());
    }

    private static void recur(int depth) {
        if (depth == R) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < R; i++) {
                temp.append(result[i]).append(' ');
            }
            String resultStr = temp.toString().trim();
            if (!set.contains(resultStr)) {
                set.add(resultStr);
                sb.append(resultStr).append('\n');
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            result[depth] = input[i];
            recur(depth + 1);
        }
    }
}
