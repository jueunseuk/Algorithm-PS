package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_6378 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;

            while (input.length() > 1) {
                input = String.valueOf(sumOfDigits(input));
            }

            System.out.println(input);
        }
    }

    private static int sumOfDigits(String number) {
        int sum = 0;
        for (char digit : number.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        return sum;
    }
}
