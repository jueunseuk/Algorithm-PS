package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10809{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int result[] = new int[26];
		Arrays.fill(result, -1);
		
		for(int i = 0 ; i < str.length(); i++) {
			for(int j = 0; j < 26; j++) {
				if(str.charAt(i) == ((char)j+'a') && result[j] == -1) {
					result[j] = i;
				}
			}
			
		}
		
		for(int i = 0; i < 26; i++) {
			System.out.print(result[i]);
			if(i < 25) System.out.print(" ");
		}
		
	}

}
