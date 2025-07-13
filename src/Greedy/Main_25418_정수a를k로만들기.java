package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25418_정수a를k로만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		while(k > n) {
			if(k % 2 == 0) {
				if(k / 2 >= n) {
					k /= 2;
					cnt++;
				} else {
					cnt += k-n;
					break;
				}
			} else {
				k--;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

}
