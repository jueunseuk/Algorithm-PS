package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1193_분수찾기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int line = 1;
        while (n > line) {
            n -= line;
            line++;
        }

        int a, b;
        if (line % 2 == 0) {
            a = n;
            b = line - n + 1;
        } else {
            a = line - n + 1;
            b = n;
        }

        System.out.println(a + "/" + b);
    }
}
