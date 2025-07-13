package Sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11656_접미사정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sb = br.readLine();
		int length = sb.length();
		
		String[] suffix = new String[length];
		
		for(int i = 0; i < length; i++) {
			suffix[i] = sb.substring(i);
		}
		
		Arrays.sort(suffix);
		
		for(String out : suffix) {
			System.out.println(out);
		}
	}

}
