package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16472_고냥이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int limit = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int n = str.length();

        if (limit >= 26) {
            System.out.println(n);
            return;
        }

        int[] cnt = new int[26];
        int kinds = 0;
        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {
            int rc = str.charAt(right) - 'a';
            if(cnt[rc]++ == 0) kinds++;

            while(kinds > limit) {
                int lc = str.charAt(left) - 'a';
                if (--cnt[lc] == 0) kinds--;
                left++;
            }
            
            ans = Math.max(ans, right - left + 1);
        }

        System.out.println(ans);
    }
}