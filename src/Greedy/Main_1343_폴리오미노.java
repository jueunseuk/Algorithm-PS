package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1343_폴리오미노 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < board.length()) {
            if (board.charAt(i) == 'X') {
                int start = i;
                while (i < board.length() && board.charAt(i) == 'X') {
                    i++;
                }
                int length = i - start;

                if (length % 2 != 0) {
                    System.out.println(-1);
                    return;
                }

                int aCount = length / 4;
                int bCount = (length % 4) / 2;

                result.append(repeatString("AAAA", aCount));
                result.append(repeatString("BB", bCount));
            } else {
                result.append(board.charAt(i));
                i++;
            }
        }

        System.out.println(result.toString());
    }

    private static String repeatString(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
