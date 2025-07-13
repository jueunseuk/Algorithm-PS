package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1722_2 {
    static int N, mode;
    static int[] number;
    static boolean[] used;
    static long[] factorial;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        number = new int[N];
        used = new boolean[N + 1];
        factorial = new long[N + 1];
        
        // 팩토리얼 미리 계산
        factorial[0] = 1;
        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        mode = Integer.parseInt(st.nextToken());
        
        if (mode == 1) {
            long k = Long.parseLong(st.nextToken());
            findPermutationByOrder(k);
        } else if (mode == 2) {
            for (int i = 0; i < N; i++) {
                number[i] = Integer.parseInt(st.nextToken());
            }
            findOrderOfPermutation();
        }
        br.close();
    }

    // k번째 순열 찾기
    private static void findPermutationByOrder(long k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                if (used[j]) continue;
                if (factorial[N - i - 1] < k) {
                    k -= factorial[N - i - 1];
                } else {
                    sb.append(j).append(" ");
                    used[j] = true;
                    break;
                }
            }
        }
        System.out.println(sb.toString().trim());
    }

    // 순열의 순서 찾기
    private static void findOrderOfPermutation() {
        long order = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < number[i]; j++) {
                if (!used[j]) {
                    order += factorial[N - i - 1];
                }
            }
            used[number[i]] = true;
        }
        System.out.println(order);
    }
}
