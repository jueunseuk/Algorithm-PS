package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_32631_두덱 {
    static int n, k;
    static int[] a, b;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n];
        b = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        dfs(n - 1, n - 1, k, sum(a, n), sum(b, n));
        System.out.println(minDifference);
    }

    static void dfs(int idxA, int idxB, int remaining, int sumA, int sumB) {
        if (remaining == 0) {
            minDifference = Math.min(minDifference, Math.max(sumA, sumB));
            return;
        }

        if (idxA >= 0) {
            dfs(idxA - 1, idxB, remaining - 1, sumA - a[idxA], sumB);
        }

        if (idxB >= 0) {
            dfs(idxA, idxB - 1, remaining - 1, sumA, sumB - b[idxB]);
        }
    }

    static int sum(int[] arr, int length) {
        int total = 0;
        for (int i = 0; i < length; i++) {
            total += arr[i];
        }
        return total;
    }
}
