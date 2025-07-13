package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2138_전구와스위치 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] origin = new int[n];
        int[] target = new int[n];

        String input1 = br.readLine();
        String input2 = br.readLine();

        for (int i = 0; i < n; i++) {
            origin[i] = input1.charAt(i) - '0';
            target[i] = input2.charAt(i) - '0';
        }

        int result1 = simulate(origin, target, n, false);
        int result2 = simulate(origin, target, n, true);

        int result = Math.min(result1, result2);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static int simulate(int[] origin, int[] target, int n, boolean firstSwitch) {
        int[] current = Arrays.copyOf(origin, n);
        int count = 0;

        if (firstSwitch) {
            flip(current, 0);
            count++;
        }

        for (int i = 1; i < n; i++) {
            if (current[i - 1] != target[i - 1]) {
                flip(current, i);
                count++;
            }
        }

        if (current[n - 1] != target[n - 1]) {
            return Integer.MAX_VALUE;
        }

        return count;
    }

    private static void flip(int[] arr, int idx) {
        arr[idx] = 1 - arr[idx];
        if (idx > 0) {
            arr[idx - 1] = 1 - arr[idx - 1];
        }
        if (idx < arr.length - 1) {
            arr[idx + 1] = 1 - arr[idx + 1];
        }
    }
}
