package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_11478_서로다른부분문자열의개수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder str = new StringBuilder(br.readLine());
		
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i <= str.length(); i++) {
			for(int j = i; j <= str.length(); j++) {
				if(!set.contains(str.substring(i, j))) {
					set.add(str.substring(i, j));
				}
			}
		}
		
		System.out.println(set.size()-1);
	}

}
