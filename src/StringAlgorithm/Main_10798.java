package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = new String[5];
		
		int maxLen = 0;
		for(int i = 0; i < 5; i++) {
			str[i] = br.readLine();
			if (str[i].length() > maxLen) {
                maxLen = str[i].length();
            }
		}
		
		for(int i = 0; i < maxLen; i++) {
			for(int j = 0; j < 5; j++) {
				if(i < str[j].length())
				System.out.print(str[j].charAt(i));
			}
		}
		
		
	}

}
