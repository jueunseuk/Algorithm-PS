package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받기
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        // 수로 생각했을 때
        int numericResult = A + B - C;
        
        // 문자열로 생각했을 때
        String strA = Integer.toString(A);
        String strB = Integer.toString(B);
        String strC = Integer.toString(C);
        
        // 두 문자열을 이어붙이고, 마지막 결과를 빼는 계산
        String combinedStr = strA + strB;
        int combinedNumericResult = Integer.parseInt(combinedStr) - Integer.parseInt(strC);
        
        // 결과 출력
        System.out.println(numericResult);
        System.out.println(combinedNumericResult);
    }
}
