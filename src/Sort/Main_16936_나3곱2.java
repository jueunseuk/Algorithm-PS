package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_16936_나3곱2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Long[] input = new Long[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = Long.parseLong(st.nextToken());
		}
		
		Comparator<Long> compare = new Comparator<Long>(){
			@Override
			public int compare(Long a, Long b) {
				if(divCount(a) != divCount(b)) {
					return divCount(b)-divCount(a);
				} else {
					return multiCount(a)-multiCount(b);
				}
			}
			
		};
		
		Arrays.sort(input, compare);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(input[i]).append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}

	protected static int multiCount(Long a) {
		int count = 0;
		while(a%2==0) {
			a/=2;
			count++;
		}
		return count;
	}

	protected static int divCount(Long a) {
		int count = 0;
		while(a%3==0) {
			a/=3;
			count++;
		}
		return count;
	}
	
	
	
	

}
