package TwoPointer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6159_CostumeParty {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int cnt = 0;
        int left = 0, right = n - 1;

        // 투 포인터 시작
        while (left < right) {
            if (arr[left] + arr[right] <= l) {
                // 왼쪽과 오른쪽 값이 조건을 만족하면, left ~ right 사이의 모든 짝을 만들 수 있음
                cnt += right - left;
                left++; // left를 이동시켜 더 큰 값을 확인
            } else {
                right--; // 조건을 만족하지 않으면 right를 왼쪽으로 이동
            }
        }

        System.out.println(cnt);

        br.close();
    }

}
