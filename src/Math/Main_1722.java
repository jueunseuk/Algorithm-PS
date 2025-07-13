package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1722 {
    static int[] number, result;
    static int order, N, mode, cnt = 0;
    static boolean[] isSelected;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isSelected = new boolean[N+1];
        result = new int[N];
        number = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        mode = Integer.parseInt(st.nextToken());
        switch(mode) {
            case 1: {
                order = Integer.parseInt(st.nextToken());
                makePermutation(0);
                break;
            }
            case 2: {
                for(int i = 0; i < N; i++) number[i] = Integer.parseInt(st.nextToken());
                makePermutation(0);
                break;
            }
        }
        br.close();
    }

    private static void makePermutation(int depth) {
        if (depth == N) {
            cnt++;
            if (mode == 1 && cnt == order) {
                for (int i = 0; i < N; i++) {
                    System.out.print(result[i]);
                    if (i < N - 1) System.out.print(" ");
                }
                System.exit(0); // 프로그램 종료
            } else if (mode == 2 && Arrays.equals(result, number)) {
                System.out.println(cnt);
                System.exit(0); // 프로그램 종료
            }
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            result[depth] = i;
            makePermutation(depth + 1);
            isSelected[i] = false;
        }
    }
}
