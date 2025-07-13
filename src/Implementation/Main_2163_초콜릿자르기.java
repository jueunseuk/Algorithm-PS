package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2163_초콜릿자르기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        if(n == 1 && m == 1) {
        	System.out.println(1);
        } else if(n == 1) {
        	System.out.println(m-1);
        } else if(m == 1) {
        	System.out.println(n-1);
        } else {
        	System.out.println(n-1+(n*(m-1)));
        }
	}
}