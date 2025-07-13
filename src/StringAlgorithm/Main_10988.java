package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main_10988 { //회문
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        int N = str.length;
        int result = 1;
        
        out:
        for(int i = 0, j = N-1; i < N/2 && j > N/2; i++, j--) {
        		if(!str[i].equals(str[j])) {
        			result -= 1;
        			break out;
        	}
        }
        
        System.out.println(result);
    }
}
