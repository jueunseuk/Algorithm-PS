package DataStructure;
import java.io.*;

public class Main_1283_단축키지정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        String[] ans = new String[8];
        if (!input.contains("::")) {
            String[] arr = input.split(":");
            for (int i = 0; i < 8; i++) ans[i] = zeroPad(arr[i]);
        } else {
            String[] parts = input.split("::", -1);
            String[] left = parts[0].isEmpty() ? new String[0] : parts[0].split(":");
            String[] right = parts.length > 1 && !parts[1].isEmpty() ? parts[1].split(":") : new String[0];
            int fill = 8 - (left.length + right.length);
            int idx = 0;
            for (String s : left) ans[idx++] = zeroPad(s);
            for (int i = 0; i < fill; i++) ans[idx++] = "0000";
            for (String s : right) ans[idx++] = zeroPad(s);
        }
        System.out.println(String.join(":", ans));
    }
    static String zeroPad(String s) {
        while (s.length() < 4) s = "0" + s;
        return s;
    }
}
