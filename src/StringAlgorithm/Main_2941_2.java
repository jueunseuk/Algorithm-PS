package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2941_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int cnt = 0;

        String[] croa = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String croatian : croa) {
            while (input.contains(croatian)) {
                input = input.replaceFirst(croatian, " ");
                cnt++;
            }
        }

        // 남은 문자들 개수 세기
        input = input.replaceAll(" ", "");
        cnt += input.length();

        System.out.println(cnt);
    }
}
