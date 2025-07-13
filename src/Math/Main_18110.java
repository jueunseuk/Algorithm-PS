package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_18110 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int []input = new int[n];
		int cut = (int) Math.round(n*0.15);
		
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input);
		
		int []filter = new int[n-cut*2];
		
		for(int i = 0; i < n - cut*2; i++) {
			filter[i] = input[i+cut];
		}
		
		double sum = 0;
		for(int i = 0; i < filter.length; i++) {
			sum += filter[i];
		}
		
		int result = (int) Math.round(sum / filter.length);
		
		System.out.println(result);
	}

}
