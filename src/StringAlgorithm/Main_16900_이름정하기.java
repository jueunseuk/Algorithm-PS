package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16900_이름정하기 {
	static int[] pi;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String pattern = st.nextToken();
		
		long n = Integer.parseInt(st.nextToken());
		
		getPi(pattern);
		
		long result = pattern.length()*n - pi[pattern.length()-1]*(n-1);
		
		System.out.println(result);
	}
	
	
	public static void getPi(String pattern) {
		int length = pattern.length();
		pi = new int[length];
		int j = 0;
		
		for(int i = 1; i < length; i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
	}
}
