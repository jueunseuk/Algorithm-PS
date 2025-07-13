package Recursion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603 {
	
	static int T;
	static int[] result = new int[6];
	static int[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			if(st.countTokens() < 6) break;
			
			T = Integer.parseInt(st.nextToken());
			num = new int[T];
			
			for(int i = 0; i < T; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			makeCombination(0, 0);
			System.out.println();
			
		}//while
		
		br.close();
	}

	private static void makeCombination(int depth, int idx) {
		if(depth == 6) {
			for(int i = 0; i < 6; i++) {
				System.out.print(result[i]);
				if(i < 5) System.out.print(" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = idx; i < T; i++) {
			result[depth] = num[i];
			makeCombination(depth+1, i+1);
		}
		
	}

}
