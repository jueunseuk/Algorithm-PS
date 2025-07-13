package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String splitStr[] = br.readLine().split("-");
		int sum[] = new int[splitStr.length];
		
		for(int i = 0; i < splitStr.length; i++) {
			String splitPlus[] = splitStr[i].split("\\+");
			for(int j = 0; j < splitPlus.length; j++) {
				sum[i] += Integer.parseInt(splitPlus[j]);
			}
		}
		
		int result = sum[0];
		for(int i = 1; i < sum.length; i++) {
			result -= sum[i];
		}
		
		System.out.println(result);
	}

}
