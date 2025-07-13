package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1323_숫자연결하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String input = st.nextToken();
		String input2 = st.nextToken();
		
		int n = Integer.parseInt(input);
		int k = Integer.parseInt(input2);
		
		long mod = n%k;
		long mul = (long) Math.pow(10, input.length());
		
		int cnt = 1;
		Set<Long> set = new HashSet<>();
		set.add(mod);
		while(true) {
			if(mod == 0) {
				break;
			}
			
			mod = (n % k + (mod * (mul % k)) % k) % k;
			
			cnt++;
			
			if(set.contains(mod)) {
				cnt = -1;
				break;
			}
			
			set.add(mod);
		}
		
		System.out.println(cnt);
	}
}