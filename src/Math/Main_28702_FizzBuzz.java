package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_28702_FizzBuzz {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String []input = new String[3];
		int []num = new int[3];
		int target = -1;
		for(int i = 0; i < 3; i++) {
			input[i] = br.readLine();
			
			try {
				num[i] = Integer.parseInt(input[i]);
				target = num[i] + 3 - i;
				
				if (target % 3 == 0 && target % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (target % 3 == 0) {
                    System.out.println("Fizz");
                } else if (target % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(target);
                }
				
				return;
			} catch (Exception e) {
				continue;
			}
		}
	}

}
