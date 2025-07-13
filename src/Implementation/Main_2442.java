package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2442 {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
        	for(int j = n-i-1; j > 0; j--) {
        		sb.append(" ");
        	}
        	for(int j = 0; j < 2*i+1; j++) {
        		sb.append("*");
        	}
        	
        	sb.append("\n");
        }
        
        System.out.println(sb.toString());
	}

}
