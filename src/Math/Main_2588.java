package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main_2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        // B의 각 자리 숫자 추출
        int B1 = B % 10;
        int B2 = (B / 10) % 10;
        int B3 = (B / 100) % 10;

        // 계산
        int result1 = A * B1;
        int result2 = A * B2;
        int result3 = A * B3;
        int finalResult = A * B;

        // 출력
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(finalResult);
    }
}
