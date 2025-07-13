package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14222_배열과연산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int arr[] = new int[n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		if(sameCheck(arr)) {
			System.out.println(1);
			return;
		}
		
		int sub[] = new int[n+1];
		boolean result = true;
		for(int i = 1; i <= n; i++) {
			if(arr[i]-i % k != 0) {
				result = false;
			}
		}
		
		System.out.println(result ? 1 : 0);
	}

	private static boolean sameCheck(int[] arr) {
		for(int i = 1; i <= arr.length-1; i++) {
			if(arr[i] != i) {
				return false;
			}
		}
		
		return true;
	}

}
