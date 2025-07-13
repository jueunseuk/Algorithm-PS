package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_12871_무한문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		int result = lcm(a.length(), b.length());

		StringBuilder a1 = new StringBuilder();
		StringBuilder b1 = new StringBuilder();
		
		for(int i = 0; i < result/a.length(); i++) {
			a1.append(a);
		}
		for(int i = 0; i < result/b.length(); i++) {
			b1.append(b);
		}
		
		System.out.println(a1.toString().equals(b1.toString()) ? 1 : 0);
		
	}
	
	public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

}
