package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10952 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[2];
		
		while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            num[0] = Integer.parseInt(st.nextToken());
            num[1] = Integer.parseInt(st.nextToken());
            
            if (num[0] == 0 && num[1] == 0) {
                break;
            }
            
            System.out.println(num[0] + num[1]);
	}
}
}