package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        
        StringTokenizer token = new StringTokenizer(str, " ");
        long A = Long.parseLong(token.nextToken());        
        long B = Long.parseLong(token.nextToken());        
        long C = Long.parseLong(token.nextToken());        
        
        // 세 수의 합을 출력
        System.out.println(A + B + C);
        
        
        br.close();
    }
}
