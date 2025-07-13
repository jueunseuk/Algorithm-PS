package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_21314_민겸수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mg = br.readLine();

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        boolean flag = false;

        String big = bigNum(sb, flag, cnt, mg);
        String small = smallNum(sb, flag, cnt, mg);

        System.out.println(big);
        System.out.println(small);
    }

    public static String bigNum(StringBuilder sb, boolean flag, int cnt, String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!flag && ch == 'K') sb.append(5);
            if (ch == 'M') {
                cnt++;
                flag = true;
            } else if (flag && ch == 'K') {
                sb.append(5);
                sb.append(repeatChar('0', cnt));
                flag = false;
                cnt = 0;
            }
        }
        if (cnt != 0) sb.append(repeatChar('1', cnt));
        return sb.toString();
    }

    public static String smallNum(StringBuilder sb, boolean flag, int cnt, String str) {
        sb.setLength(0);
        flag = false;
        cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!flag && ch == 'K') sb.append(5);
            if (ch == 'M') {
                cnt++;
                flag = true;
            } else if (flag && ch == 'K') {
                sb.append(1);
                sb.append(repeatChar('0', cnt - 1));
                sb.append(5);
                flag = false;
                cnt = 0;
            }
        }
        if (cnt != 0) sb.append(1).append(repeatChar('0', cnt - 1));
        return sb.toString();
    }

    public static String repeatChar(char ch, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
