package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15803_배틀그라운드 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double px1 = Double.parseDouble(st.nextToken());
        double py1 = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        double px2 = Double.parseDouble(st.nextToken());
        double py2 = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        double px3 = Double.parseDouble(st.nextToken());
        double py3 = Double.parseDouble(st.nextToken());

        if(px1==px2 || px2==px3 || px3==px1) {
            if(px1==px2 && px2==px3)
                System.out.println("WHERE IS MY CHICKEN?");
            else
                System.out.println("WINNER WINNER CHICKEN DINNER!");
        }

        else if(py1==py2 || py2==py3 || py3==py1) {
            if(py1==py2 && py2==py3)
                System.out.println("WHERE IS MY CHICKEN?");
            else
                System.out.println("WINNER WINNER CHICKEN DINNER!");
        }

        else {
            if((py2-py1)/(px2-px1)==(py3-py1)/(px3-px1))
                System.out.println("WHERE IS MY CHICKEN?");
            else
                System.out.println("WINNER WINNER CHICKEN DINNER!");
        }
    }
}
