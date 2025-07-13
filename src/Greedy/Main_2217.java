package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_2217 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Integer []weight = new Integer[T];
		
		for(int i = 0; i < T; i++) {
			weight[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(weight, Collections.reverseOrder());
		
		int[] maxW = new int[T];
		for(int i = 0; i < T; i++) {
			maxW[i] = weight[i]*(i+1);
		}
		
		int result = 0;
		
		for(int i = 0; i < T; i++) {
			if(maxW[i] > result) result = maxW[i];
		}
		
		System.out.println(result);

	}

}
