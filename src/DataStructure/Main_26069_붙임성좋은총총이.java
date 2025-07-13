package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_26069_붙임성좋은총총이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String origin = "ChongChong";
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			String input[] = br.readLine().split(" ");
			if(input[0].equals(origin) || input[1].equals(origin) || (set.contains(input[0]) || set.contains(input[1]))) {
				set.add(input[0]);
				set.add(input[1]);
			}
			
		}
		
		System.out.println(set.size());
	}

}
