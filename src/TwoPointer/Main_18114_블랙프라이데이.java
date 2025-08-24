package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18114_블랙프라이데이 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] input = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            if (input[i] == c) {
                System.out.println(1);
                return;
            }
        }

        Arrays.sort(input);

        int l = 0, r = n - 1;
        while (l < r) {
            int sum = input[l] + input[r];
            if (sum == c) {
            	System.out.println(1);
            	return;
        	}
            if (sum < c) l++;
            else r--;
        }

        for (int i = 0; i < n; i++) {
            if (input[i] > c) break;
            int target = c - input[i];
            int left = i + 1, right = n - 1;
            while (left < right) {
                int s = input[left] + input[right];
                if (s == target) {
                	System.out.println(1);
                	return;
            	}
                if(s < target) left++;
                else right--;
            }
        }

        System.out.println(0);
    }
}
