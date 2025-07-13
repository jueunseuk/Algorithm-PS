package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14928_큰수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        String number = br.readLine();
        int mod = 20000303;
        int result = 0;

        for (int i = 0; i < number.length(); i++) {
            result = (int)((result * 10L + (number.charAt(i) - '0')) % mod);
        }

        System.out.println(result);
	}
}