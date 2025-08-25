package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_3661_생일선물 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

            int base = p / n;
            Info[] arr = new Info[n];
            int given = 0;
            for (int i = 0; i < n; i++) {
                int pay = Math.min(a[i], base);
                arr[i] = new Info(i, a[i], pay);
                given += pay;
            }

            int left = p - given;
            Arrays.sort(arr);

            int cursor = 0;
            while (left != 0) {
                if (cursor == arr.length || arr[cursor].max - arr[cursor].pay == 0) {
                    if (cursor == 0) break;
                    cursor = 0;
                    continue;
                }
                arr[cursor].pay += 1;
                left -= 1;
                cursor += 1;
            }

            if (left != 0) {
                sb.append("IMPOSSIBLE\n");
            } else {
                Arrays.sort(arr, Comparator.comparingInt(o -> o.ind));
                for (int i = 0; i < n; i++) {
                    sb.append(arr[i].pay);
                    sb.append(i + 1 == n ? '\n' : ' ');
                }
            }
        }

        System.out.print(sb.toString().trim());
    }
    
    static class Info implements Comparable<Info> {
        int ind, max, pay;
        
        Info(int ind, int max, int pay) {
            this.ind = ind;
            this.max = max;
            this.pay = pay;
        }
        
        @Override
        public int compareTo(Info o) {
            if (this.max != o.max) return o.max - this.max;
            return this.ind - o.ind;
        }
    }
}