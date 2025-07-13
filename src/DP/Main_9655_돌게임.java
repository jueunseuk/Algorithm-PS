package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9655_돌게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(n % 2 == 1 ? "SK" : "CY");
	}

}
