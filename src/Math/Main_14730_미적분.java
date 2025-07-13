package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14730_미적분 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int result = 0;
        
        StringTokenizer st;
        for(int i = 0; i < n-1; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	result += Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(b != 0) {
        	result += a*b;
        }
        
        System.out.println(result);

	}

}
