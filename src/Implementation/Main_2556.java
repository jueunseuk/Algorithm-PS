package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2556 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		sb.append("*");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString());

	}

}