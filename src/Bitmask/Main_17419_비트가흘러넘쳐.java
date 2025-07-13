package Bitmask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17419_비트가흘러넘쳐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		long target = Long.parseLong(input, 2);
		int cnt = Long.bitCount(target);
		
		System.out.println(cnt);
	}

}
