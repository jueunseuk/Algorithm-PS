package TwoPointer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_20922_겹치는건싫어 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxL = 0;
        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            int current = arr[right];
            map.put(current, map.getOrDefault(current, 0) + 1);

            while (map.get(current) > k) {
                int leftValue = arr[left];
                map.put(leftValue, map.getOrDefault(leftValue, 0) - 1);

                if (map.get(leftValue) == 0) {
                    map.remove(leftValue);
                }
                left++;
            }

            maxL = Math.max(maxL, right - left + 1);
            right++;
        }

        System.out.println(maxL);
    }
}
