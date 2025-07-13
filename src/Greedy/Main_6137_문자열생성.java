package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_6137_문자열생성 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] arr = new char[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().charAt(0);
        }

        StringBuilder sb = new StringBuilder();

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            boolean takeLeft = false;

            for (int i = 0; left + i <= right - i; i++) {
                if (arr[left + i] < arr[right - i]) {
                    takeLeft = true;
                    break;
                } else if (arr[left + i] > arr[right - i]) {
                    takeLeft = false;
                    break;
                }
            }

            if (takeLeft) {
                sb.append(arr[left++]);
            } else {
                sb.append(arr[right--]);
            }
        }

        for (int i = 0; i < sb.length(); i += 80) {
            System.out.println(sb.substring(i, Math.min(i + 80, sb.length())));
        }
    }
}
