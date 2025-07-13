package BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {
	static int L, C;
	static String input[], result[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken()); //L개를 선택
		C = Integer.parseInt(st.nextToken()); //총 C개의 원소 중에
		
		input = br.readLine().split(" ");
		
		Arrays.sort(input);
		
		result = new String[L];
		
		makeCombination(0, 0);
		
		br.close();
	}

	private static void makeCombination(int depth, int idx) {
		if(depth == L) {
			if(conditionCheck(result)) {
				for(int i = 0; i < L; i++)
				System.out.print(result[i]);
				System.out.println();
			}
			return;
		}
		
		for(int i = idx; i < C; i++) {
			result[depth] = input[i];
			makeCombination(depth + 1, i+1);
		}
		
		
	}

	private static boolean conditionCheck(String[] result) {
		int vowels = 0;
		int consonants = 0;
		
		for(int i = 0; i < result.length; i++) {
			if(result[i].equals("a") || result[i].equals("e") || result[i].equals("i") || result[i].equals("o") || result[i].equals("u")) {
				vowels++;
			}
			else consonants++;
		}
		
		if(vowels>=1 && consonants>=2) return true;
		else return false;
	}
}
