package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main_1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Map<Character, Integer> map = new HashMap<>();
		
		String newstr = str.toLowerCase();
		
		map.put(newstr.charAt(0), 1);
		for(int i = 1; i < newstr.length(); i++) {
			if(map.containsKey(newstr.charAt(i))) {
				map.computeIfPresent(newstr.charAt(i), (key, val) -> val+1);
			}
			else {
				map.put(newstr.charAt(i), 1);
			}
		}
		
		char maxKey = '\0';
		int maxValue = 0;
		boolean isDuplicate = false;
		
		for (Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
                isDuplicate = false;
            } else if (entry.getValue() == maxValue) {
                isDuplicate = true;
            }
        }
		
		
		if (isDuplicate) {
            System.out.println("?");
        } else {
            System.out.println(Character.toUpperCase(maxKey));
        }
	}

}
