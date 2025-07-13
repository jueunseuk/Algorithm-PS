package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10797_10부제 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int k = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 5; i++) {
        	if(Integer.parseInt(st.nextToken()) == k) {
        		cnt++;
        	}
        }

        System.out.println(cnt);
	}

}
