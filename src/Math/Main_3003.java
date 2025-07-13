package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] peice = new int[] {1,1,2,2,2,8};
        int[] input = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < 6; i++) input[i] = Integer.parseInt(st.nextToken());
        
        for(int i = 0 ; i < 6; i++) {
        	System.out.print(peice[i]-input[i]);
        	if(i < 5) System.out.print(" ");
        }
    }
}
