package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10039_평균점수 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        if(a < 40) a = 40;
        int b = Integer.parseInt(br.readLine());
        if(b < 40) b = 40;
        int c = Integer.parseInt(br.readLine());
        if(c < 40) c = 40;
        int d = Integer.parseInt(br.readLine());
        if(d < 40) d = 40;
        int e = Integer.parseInt(br.readLine());
        if(e < 40) e = 40;
        
        System.out.println((a+b+c+d+e)/5);
	}
}