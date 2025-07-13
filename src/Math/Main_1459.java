package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1459 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int straight = Integer.parseInt(st.nextToken());
        int diagonal = Integer.parseInt(st.nextToken());

        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }

        long totalT = 0;
        if (straight * 2 <= diagonal) {
            totalT = (long) (x + y) * straight;
        } else {
            totalT += (long) x * diagonal;
            int remaining = y - x;

            if (diagonal < straight) {
                totalT += (long) (remaining / 2) * 2 * diagonal;
                if (remaining % 2 != 0) {
                    totalT += straight;
                }
            } else {
                totalT += (long) remaining * straight;
            }
        }

        System.out.println(totalT);
    }
}
