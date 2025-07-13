package BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15657 {
    static int N, R;
    static int[] input;
    static int[] result;
    static boolean[] isSelected;
    static Set<String> set;

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

        // 정렬
        Arrays.sort(input);

        result = new int[R];
        isSelected = new boolean[N];
        set = new LinkedHashSet<>();

        permute(0);

        for (String s : set) {
            System.out.println(s);
        }
        br.close();
    }

    private static void permute(int depth) {
        if (depth == R) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                sb.append(result[i]).append(' ');
            }
            set.add(sb.toString().trim());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            result[depth] = input[i];
            permute(depth + 1);
            isSelected[i] = false;
        }
    }
}
