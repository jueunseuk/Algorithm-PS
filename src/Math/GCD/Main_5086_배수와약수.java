package Math.GCD;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5086_배수와약수 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if(a == 0) {
        		System.out.println(sb.toString().trim());
        		return;
        	}
        	
        	if(a > b) {
        		if(a % b == 0) {
        			sb.append("multiple"+"\n");
        			continue;
        		}
        	} else {
        		if(b % a == 0) {
        			sb.append("factor"+"\n");
        			continue;
        		}
        	}
        	
        	sb.append("neither"+"\n");
        }

	}

}
