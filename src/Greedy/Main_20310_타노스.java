package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_20310_타노스 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input[] = br.readLine().split("");
        
        int length = input.length;
        int one = 0, zero = 0;
        for(int i = 0; i < length; i++) {
        	if(input[i].equals("1")) {
        		one++;
        	} else {
        		zero++;
        	}
        }
        
        one >>= 1;
        zero >>= 1;
        
        for(int i = 0; one > 0 && i < length; i++) {
        	if(input[i].equals("1")) {
        		input[i] = "";
        		one--;
        	}
        }
        
        for(int i = length-1; zero > 0 && i >= 0; i--) {
        	if(input[i].equals("0")) {
        		input[i] = "";
        		zero--;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(String out : input) {
        	sb.append(out);
        }

        System.out.println(sb.toString().trim());
	}

}
