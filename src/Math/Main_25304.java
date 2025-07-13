package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int total = Integer.parseInt(br.readLine());
        int type = Integer.parseInt(br.readLine());
        
        int totalSum = 0;
        for(int i = 0; i < type; i++) {
        	String input = br.readLine();
        	StringTokenizer st = new StringTokenizer(input, " ");
        	int price = Integer.parseInt(st.nextToken());
        	int quantity = Integer.parseInt(st.nextToken());
        	
        	totalSum += (price*quantity);
        }
        
        if(totalSum == total) System.out.println("Yes");
        else System.out.println("No");
        
    }
}
