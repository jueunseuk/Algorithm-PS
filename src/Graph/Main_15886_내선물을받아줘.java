package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15886_내선물을받아줘 {
	static int n, cnt = 0;
	static char[] matrix;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        matrix = br.readLine().toCharArray();
        
        int idx = 0;
        while(idx < n) {
        	while(idx < n && matrix[idx] == 'E') {
        		idx++;
        	}
        	while(idx < n && matrix[idx] == 'W') {
        		idx++;
        	}
        	
        	cnt++;
        }
        
        System.out.println(cnt);
	}
}