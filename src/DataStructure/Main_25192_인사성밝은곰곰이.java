package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_25192_인사성밝은곰곰이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		int cnt = 0;
		
		for(int i = 0 ; i < n; i++) {
			String input = br.readLine();
			if(input.equals("ENTER")) {
				set.clear();
			} else {
				int size = set.size();
				set.add(input);
				if(size != set.size()) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		br.close();
		
	}

}
