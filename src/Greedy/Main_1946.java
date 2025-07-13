package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] input = new int[N + 1];
            
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                // 석차는 unique한 값이기 때문에 인덱스로 사용 가능
                input[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }
            
            // 서류 심사 성적을 기준으로 정렬된 상태에서 면접 성적 비교
            // 일단 첫번째 지원자는 무조건 뽑기 때문에 cnt = 1
            int cnt = 1;
            int interview = input[1];
            
            for (int j = 2; j <= N; j++) {
                if (input[j] < interview) {
                    cnt++;
                    interview = input[j];
                }
            }
            
            System.out.println(cnt);
        }
    }
}
