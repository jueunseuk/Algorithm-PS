package StringAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11655_ROT13 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] input = br.readLine().toCharArray();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length; i++) {
        	if(isCharacter(input[i])) {
        		sb.append(getCharacter(input[i]));
        	} else {
        		sb.append(input[i]);
        	}
        }

        System.out.println(sb.toString().trim());
	}

	private static char getCharacter(char c) {
		if(c < 91) {
			c += 13;
			return (char) (c > 90 ? c-26 : c);
		} else {
			c += 13;
			return (char) (c > 122 ? c-26 : c);
		}
	}

	private static boolean isCharacter(char c) {
		if(c < 65) return false;
		if(c > 90 && c < 97) return false;
		if(c > 122) return false;
		return true;
	}
}