package PrefixSum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 1, end = 1, sum = 1, cnt = 0;
        while (start <= end && end <= N) {
            if (sum < N) {
                end++;
                if (end <= N) sum += end;
            } else if (sum > N) {
                sum -= start;
                start++;
            } else {
                cnt++;
                sum -= start;
                start++;
            }
        }
        System.out.println(cnt);
    }
}