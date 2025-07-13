package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2908 {

	public static void main(String[] args) throws NumberFormatException, IOException { // 상수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = new String[2];
		input = br.readLine().split(" ");
		
		String[] A = input[0].split("");
		String[] B = input[1].split("");
		
		int intA[] = new int[3];
		int intB[] = new int[3];
		
		for(int i = 0; i < 3; i++) intA[i] = Integer.parseInt(A[i]);
		for(int i = 0; i < 3; i++) intB[i] = Integer.parseInt(B[i]);
		
		if(intA[2] > intB[2]) {
			for(int i = 2; i >= 0; i--) System.out.print(intA[i]);
		}
		else if(intA[2] < intB[2]) {
			for(int i = 2; i >= 0; i--) System.out.print(intB[i]);
		}
		else {
			if(intA[1] > intB[1]) {
				for(int i = 2; i >= 0; i--) System.out.print(intA[i]);
			}
			else if(intA[1] < intB[1]) {
				for(int i = 2; i >= 0; i--) System.out.print(intB[i]);
			}
			else {
				if(intA[0] > intB[0]) {
					for(int i = 2; i >= 0; i--) System.out.print(intA[i]);
				}
				else {
					for(int i = 2; i >= 0; i--) System.out.print(intB[i]);
				}
			}
		}
	}

}
