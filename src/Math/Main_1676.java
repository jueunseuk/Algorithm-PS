package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1676 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        for (int i = 5; N / i > 0; i *= 5) {
            count += N / i;
        }
        
        System.out.println(count);
        br.close();
    }
}
