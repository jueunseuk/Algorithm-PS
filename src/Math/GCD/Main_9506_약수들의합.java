package Math.GCD;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_9506_약수들의합 {
	static final String NP = " is NOT perfect.";
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int input;
        List<Integer> list;
        while(true) {
        	input = Integer.parseInt(br.readLine());
        	
        	if(input == -1) {
        		break;
        	}
        	
        	list = new ArrayList<>();
        	
        	int sum = 0;
        	int limit = (int) Math.sqrt(input);
        	for(int i = 1; i <= limit; i++) {
        		if(input % i == 0) {
        			list.add(i);
        			list.add(input/i);
        			sum += i + input/i;
        		}
        	}
        	
        	if(sum == input << 1) {
        		sb.append(input).append(" = ");
        		printPerfect(list);
        	} else {
        		sb.append(input).append(NP).append("\n");
        	}
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void printPerfect(List<Integer> list) {
		Collections.sort(list);
		for(int i = 0; i < list.size()-1; i++) {
			sb.append(list.get(i));
			if(i < list.size() - 2) {
				sb.append(" + ");
			}
		}
		
		sb.append("\n");
	}
}