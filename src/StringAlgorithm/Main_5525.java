package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int leng = Integer.parseInt(br.readLine());
        String input = br.readLine();
        
        int count = 0;
        int i = 0;
        
        while (i < leng - 2) {
            if (input.charAt(i) == 'I' && input.charAt(i + 1) == 'O' && input.charAt(i + 2) == 'I') {
                int consecutiveCount = 0;
                
                while (i + 2 < leng && input.charAt(i) == 'I' && input.charAt(i + 1) == 'O' && input.charAt(i + 2) == 'I') {
                    consecutiveCount++;
                    i += 2;
                }
                
                if (consecutiveCount >= n) {
                    count += (consecutiveCount - n + 1);
                }
            } else {
                i++;
            }
        }
        
        System.out.println(count);
    }
}
