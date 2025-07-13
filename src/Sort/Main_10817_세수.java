package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10817_세수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " "	);
		
		int a[] = new int[3];
		
		for(int i = 0 ; i < 3 ; i++) {
			 a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		
		System.out.println(a[1]);
	}

}
