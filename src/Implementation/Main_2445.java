package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2445 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int row = n*2-1;
        int col = n*2;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < row/2; i++) {
        	for(int j = 0; j < i+1; j++) {
        		sb.append("*");
        	}
        	
        	for(int j = 2*(n-i-1); j > 0; j--) {
        		sb.append(" ");
        	}
        	
        	for(int j = 0; j < i+1; j++) {
        		sb.append("*");
        	}
        	
        	sb.append("\n");
        }
        
        for(int i = row/2+1; i <= row; i++) {
        	for(int j = n*2-i; j > 0; j--) {
        		sb.append("*");
        	}
        	
        	for(int j = 0; j < 2*(i-n); j++) {
        		sb.append(" ");
        	}
        	
        	for(int j = n*2-i; j > 0; j--) {
        		sb.append("*");
        	}
        	
        	sb.append("\n");
        }
        
        System.out.println(sb.toString().trim());

	}

}
