package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2455_지능형기차 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int result = 0;
        int curr = 0;
        
        StringTokenizer st;
        for(int i = 0; i < 4; i++) {
        	st = new StringTokenizer(br.readLine()," ");
        	curr -= Integer.parseInt(st.nextToken());
        	curr += Integer.parseInt(st.nextToken());
        	
        	result = Math.max(result, curr);
        }
        
        System.out.println(result);
	}
}