package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2744_대소문자바꾸기 {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        
        char[] c = input.toCharArray();
        
        for(int i = 0; i < input.length(); i++) {
        	if(c[i] >= 97) {
        		c[i] -= 32;
        	} else {
        		c[i] += 32;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char out : c) {
        	sb.append(out);
        }
        
        System.out.println(sb.toString());
	}
}
