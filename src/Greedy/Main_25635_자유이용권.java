package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25635_자유이용권 {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long total = 0;
        long max = 0;
        
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            total += a;
            max = Math.max(max, a);
        }
        
        long others = total - max;
        long answer;
        
        if (max > others + 1) {
            answer = 2 * others + 1;
        } else {
            answer = total;
        }
        
        System.out.println(answer);
    }
}
