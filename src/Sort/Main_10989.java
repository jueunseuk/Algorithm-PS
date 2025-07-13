package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Main_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int input[] = new int[N];
        
        for(int i = 0; i < N; i++) {
        	input[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(input);
        
        for(int i = 0; i < N; i++) {
        	System.out.println(input[i]);
        }
        
    }
}
