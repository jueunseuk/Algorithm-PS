package Bitmask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main_1094_막대기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		String str = Integer.toBinaryString(n);
		for(int i = 0 ; i < str.length(); i++) {
			if(str.charAt(i)=='1') {
				count++;
			}
		}
		System.out.println(count);
	}

}
