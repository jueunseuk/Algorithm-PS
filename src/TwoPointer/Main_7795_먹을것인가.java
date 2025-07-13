package TwoPointer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7795_먹을것인가 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int[] a = new int[A];
			int[] b = new int[B];
			
			// a 배열 입력
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < A; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			// b 배열 입력
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < B; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(b);
			
			// 개수 체크
			int cnt = 0;
			for(int i = 0; i < A; i++) {
				int idx = Arrays.binarySearch(b, a[i]);
				if(idx < 0) {
					idx = -idx-1;
				} else {
					while (idx > 0 && b[idx - 1] == a[i]) { // 같은 값이 여러개일수도 있기 때문에
				        idx--;
				    }
				}
				cnt += idx;
			}
			
			System.out.println(cnt);
			
		}
		
		
		br.close();
	}

}
