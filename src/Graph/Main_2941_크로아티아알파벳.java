package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2941_크로아티아알파벳 {

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

        input = input.replaceAll(" ", "");
        cnt += input.length();

        System.out.println(cnt);
    }
}
