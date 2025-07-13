package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int cnt = 0;
		
		String[] croa = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		StringBuilder sb = new StringBuilder(input);
		
		while(!sb.isEmpty()) {
			int size = sb.length();
			
			escapefor:
			for(int i = 2; i <= 3 && sb.length() > i; i++) {
				String str = sb.substring(0, i);
				for(int j = 0; j < 8; j++) {
					if(str.equals(croa[j])) {
						sb.delete(0, i);
						break escapefor;
					}//if
				}//inner_for
				
			}//escape
			
			if(size == sb.length()) //변경된 알파벳이 없는 경우
			sb.deleteCharAt(0);
			
			cnt++;
			
			
		}//while
		
		
		System.out.println(cnt);
	}

}
