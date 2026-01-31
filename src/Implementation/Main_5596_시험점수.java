package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5596_시험점수 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sum0 = 0;
        for(int i = 0; i < 4; i++) {
        	sum0 += Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        int sum1 = 0;
        for(int i = 0; i < 4; i++) {
        	sum1 += Integer.parseInt(st.nextToken());
        }
        
        System.out.println(Math.max(sum0, sum1));
	}
}