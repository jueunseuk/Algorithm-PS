package Preprocessing;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_9289_MorseCode {
	static StringBuilder sb = new StringBuilder();
	static Map<String, Character> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		map.put(".-", 'A');
		map.put("-...", 'B');
		map.put("-.-.", 'C');
		map.put("-..", 'D');
		map.put(".", 'E');
		map.put("..-.", 'F');
		map.put("--.", 'G');
		map.put("....", 'H');
		map.put("..", 'I');
		map.put(".---", 'J');
		map.put("-.-", 'K');
		map.put(".-..", 'L');
		map.put("--", 'M');
		map.put("-.", 'N');
		map.put("---", 'O');
		map.put(".--.", 'P');
		map.put("--.-", 'Q');
		map.put(".-.", 'R');
		map.put("...", 'S');
		map.put("-", 'T');
		map.put("..-", 'U');
		map.put("...-", 'V');
		map.put(".--", 'W');
		map.put("-..-", 'X');
		map.put("-.--", 'Y');
		map.put("--..", 'Z');
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        String []input;
        StringBuilder result = new StringBuilder();
        for(int t = 1; t <= T; t++) {
        	input = br.readLine().split(" ");
        	
        	for(int i = 0; i < input.length; i++) {
        		result.append(map.get(input[i]));
        	}
        	
        	saveResult(t, result.toString());
        	
        	result.setLength(0);
        }
        
        
        System.out.println(sb.toString().trim());
	}
	
	public static void saveResult(int idx, String result) {
		sb.append("Case ").append(idx).append(": ").append(result).append("\n");
	}

}
