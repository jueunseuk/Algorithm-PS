package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20206_푸앙이가길을건너간이유 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        int x[] = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int y[] = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        
        long r1 = a*x[0]+b*y[0]+c;
        long r2 = a*x[1]+b*y[0]+c;
        long r3 = a*x[0]+b*y[1]+c;
        long r4 = a*x[1]+b*y[1]+c;
        
        if((r1 >= 0 && r2 >= 0 && r3 >= 0 && r4 >= 0) || (r1 <= 0 && r2 <= 0 && r3 <= 0 && r4 <= 0)) {
        	System.out.println("Lucky");
        } else {
        	System.out.println("Poor");
        }
	}

}
