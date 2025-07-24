package StringAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_4999_아 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		if(str1.length() < str2.length()) {
			System.out.println("no");
		} else {
			System.out.println("go");
		}
	}
}