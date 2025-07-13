package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11758_CCW {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] a = new long[2];
        long[] b = new long[2];
        long[] c = new long[2];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a[0] = Long.parseLong(st.nextToken());
        a[1] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        b[0] = Long.parseLong(st.nextToken());
        b[1] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        c[0] = Long.parseLong(st.nextToken());
        c[1] = Long.parseLong(st.nextToken());

        long orientation = (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]);

        if (orientation > 0) {
            System.out.println(1);
        } else if (orientation < 0) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
    }

}
