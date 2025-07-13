package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5543_상근날드 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        
        a = Math.min(a, Math.min(b, c));
        d = Math.min(d, e);
        
        System.out.println(a+d-50);
	}

}
