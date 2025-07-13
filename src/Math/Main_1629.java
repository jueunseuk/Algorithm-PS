package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_1629 { // 소수 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        String B = st.nextToken();
        String C = st.nextToken();
        int intA = Integer.parseInt(A);
        int intB = Integer.parseInt(B);
        int intC = Integer.parseInt(C);
        
        BigInteger bi = new BigInteger(A);
        BigInteger result = new BigInteger("1");
        
        for(int i = 1; i <= intB; i++) {
        	result = bi.multiply(BigInteger.valueOf(intA));
        }
        
        System.out.println(result.mod(BigInteger.valueOf(intC)));
        
        br.close();
    }//main
}