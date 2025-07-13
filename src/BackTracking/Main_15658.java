package BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15658 {
    static int N, max, min;
    static int[] input, operators;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 숫자 입력
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        //연산자 개수 입력
        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        recursive(input[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    static void recursive(int result, int idx) {
        if (idx == N) {
            if (result > max) max = result;
            if (result < min) min = result;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--; //연산자 사용
                //연산자 사용할때마다 수식 계산
                int nextResult = calculate(result, input[idx], i);
                recursive(nextResult, idx + 1);
                operators[i]++; //연산자 복구
            }
        }
    }//recursive

    //계산기
    static int calculate(int num1, int num2, int op) {
        switch (op) {
            case 0: return num1 + num2;
            case 1: return num1 - num2;
            case 2: return num1 * num2;
            case 3: return num1 / num2;
        }
        return 0;
    }
}
