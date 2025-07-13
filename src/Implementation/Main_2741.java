package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2741 {
	public static void main(String[] args) throws NumberFormatException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[8];
		int check[] = new int[3];
		Arrays.fill(check, 1);
		
		for(int i = 0 ; i < 8; i++)
		arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < 7; i++) {
			if(arr[i]+1 == arr[i+1])
				check[0] = 1;
			else {
				check[0] = 0;
				break;
			}
		}
		for(int i = 0; i < 7; i++) {
			if(arr[i]-1 == arr[i+1])
				check[1] = 1;
			else {
				check[1] = 0;
				break;
			}
		}
		
		if(check[0] == 1) {
			System.out.println("ascending");
			return;
		}
		else if(check[1] == 1) {
			System.out.println("descending");
			return;
		}
		else System.out.println("mixed");
		
	}
}
