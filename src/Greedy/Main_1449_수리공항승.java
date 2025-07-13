package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1449_수리공항승 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] hole = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) hole[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(hole);

        int cnt = 0;
        int idx = 0;
        while (idx < N) {
            int coverEnd = hole[idx] + L - 1;
            cnt++;
            while (idx < N && hole[idx] <= coverEnd) idx++;
        }
        System.out.println(cnt);
    }
}
