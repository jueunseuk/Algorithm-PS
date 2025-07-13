package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3366_수열줄이기 { // 스택의 배열화
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] stack = new int[n + 1];
        int top = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        stack[top++] = Integer.MAX_VALUE;

        for (int i = 0; i < n;) {
            if (arr[i] < stack[top - 1]) {
                stack[top++] = arr[i];
            } else {
                if (stack[top - 2] > arr[i]) {
                    ans += arr[i];
                    stack[top - 1] = arr[i];
                } else {
                    ans += stack[top - 2];
                    top--;
                    continue;
                }
            }
            i++;
        }

        for (int i = top - 1; i > 1; i--) {
            ans += stack[i - 1];
        }

        System.out.println(ans);
    }
}