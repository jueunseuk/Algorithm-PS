package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10995 {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        if(n == 1) {
        	System.out.println("*");
        	return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        StringBuilder row = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
        	row.append("*");
        	if(i < n-1) row.append(" ");
        }
        
        for(int i = 0; i < n; i++) {
        	if(i % 2 == 0) {
        		sb.append(row);
        	} else {
        		sb.append(" ").append(row);
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString());
	}
}
