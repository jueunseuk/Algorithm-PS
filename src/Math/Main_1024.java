package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int start = 1, end = 1, sum = 1, cnt = 0;
        while (start <= end && end <= N) {
            if (sum < N) {
                end++;
                if (end <= N) sum += end;
            } else if (sum > N) {
                sum -= start;
                start++;
            } else {
            	if(start-end>L)
                cnt++;
                sum -= start;
                start++;
            }
        }
        if(cnt>=1)
        System.out.println(cnt);
        else {
        	System.out.println(-1);
        }
    }
}