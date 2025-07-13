package PrefixSum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int []input = new int[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int cnt = 0;
		int tempSum = 0;
		
		while (end <= N) {
            if (tempSum >= target) {
                tempSum -= input[start++];
            } else {
                if (end == N) break;
                tempSum += input[end++];
            }

            if (tempSum == target) {
                cnt++;
            }
        }
		
		System.out.println(cnt);
		
	}

}
