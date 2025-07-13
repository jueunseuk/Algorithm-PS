package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1689_겹치는선분 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] starts = new int[n];
        int[] ends = new int[n];
        
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            starts[i] = Integer.parseInt(st.nextToken());
            ends[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int startIndex = 0;
        int endIndex = 0;
        int current = 0;
        int result = 0;

        // 시작하는 시각과 끝나는 시각으로 최대 개수 파악
        while (startIndex < n && endIndex < n) {
            if (starts[startIndex] < ends[endIndex]) {
                current++;
                result = Math.max(result, current);
                startIndex++;
            } else {
                current--;
                endIndex++;
            }
        }

        System.out.println(result);
    }
}
