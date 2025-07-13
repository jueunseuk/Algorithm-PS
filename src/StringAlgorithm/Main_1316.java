package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//문자열 개수 입력
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		String[] str = new String[N];
		
		//String 배열에 각각의 문자열 입력
		for(int i = 0; i < N; i++) str[i] = br.readLine();
		
		//그룹 단어 체크
		for(int i = 0; i < N; i++) {
			Set<Character> seen = new HashSet<Character>();
			char prevChar = str[i].charAt(0);
			boolean result = true;
			seen.add(prevChar);
			
			for(int j = 0; j < str[i].length(); j++) {
				char currentChar = str[i].charAt(j);
				
				if (currentChar != prevChar) {
	                if (seen.contains(currentChar)) {
	                	result = false;
	                	break;
	                }
	                seen.add(currentChar);
	            }
				prevChar = currentChar;
			}//inner_for
			
			if(result) count++;
			
			
		}//outer_for
		
		System.out.println(count);
		
		br.close();
	}

}
