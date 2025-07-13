package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Main_9093 {

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Function<String, String> reverse = (str) -> {
        	StringBuilder sb = new StringBuilder(str);
        	sb.reverse();
        	
			return sb.toString();
        };
        
        for(int i = 0; i < N; i++) {
        	String input[] = br.readLine().split(" ");
        	
        	for(int j = 0; j < input.length; j++) {
        		input[j] = reverse.apply(input[j]);
        	}
        	
        	StringBuilder sb = new StringBuilder();
        	for(int j = 0; j < input.length; j++) {
        		sb.append(input[j]).append(" ");
        	}
        	System.out.println(sb.toString().trim());
        }
        
        
	}

}
