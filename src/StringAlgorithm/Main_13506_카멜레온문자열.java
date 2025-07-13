package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_13506_카멜레온문자열 {
	static int[] pi;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		create(input);
		
		int length = pi[input.length()-1];
		
		while (length > 0) {
            if (contains(pi, length)) {
                System.out.println(input.substring(0, length));
                return;
            }
            length = pi[length - 1];
        }
		
		System.out.println(-1);
	}
	
	public static int[] create(String pattern) {
		int length = pattern.length();
		pi = new int[length];
		int j = 0;
		
		for(int i = 1; i < length; i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
	
	public static boolean contains(int[] pi, int len) {
        for (int i = 0; i < pi.length - 1; i++) {
            if (pi[i] == len) {
                return true;
            }
        }
        return false;
    }
}
