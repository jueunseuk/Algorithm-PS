package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_12605_단어순서뒤집기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
        	String[] input = br.readLine().split(" ");
        	sb.append("Case #").append(i+1).append(": ");
        	for(int k = input.length-1; k >= 0; k--) {
        		sb.append(input[k]).append(" ");
        	}
        	sb.deleteCharAt(sb.length()-1);
        	sb.append("\n");
        }
        
        System.out.println(sb.toString());
	}

}
