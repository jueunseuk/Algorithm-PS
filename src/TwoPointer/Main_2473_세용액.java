package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_세용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long minGap = Long.MAX_VALUE; // 절대값이 가장 작은 수 찾기
        long[] result = new long[3];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];

                if (Math.abs(sum) < Math.abs(minGap)) {
                    minGap = sum; // 실제 sum 값 저장
                    result[0] = arr[i];
                    result[1] = arr[left];
                    result[2] = arr[right];
                }

                // 합이 0인 경우, 즉시 종료
                if (sum == 0) {
                    break;
                }

                // 포인터 이동
                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        Arrays.sort(result); // 세 용액을 오름차순으로 출력
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
