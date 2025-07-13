package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5073_삼각형 {
	static final String EQ = "Equilateral";
	static final String IS = "Isosceles";
	static final String SC = "Scalene";
	static final String IN = "Invalid";

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x, y, z;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true) {
        	st = new StringTokenizer(br.readLine());
        	
        	x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());
        	z = Integer.parseInt(st.nextToken());
        	
        	if(x == 0 && y == 0 && z == 0) {
        		break;
        	}
        	
        	if(x == y && y == z) {
        		sb.append(EQ).append("\n");
        		continue;
        	}
        	
        	if(x+y <= z || x+z <= y || y+z <= x) {
        		sb.append(IN).append("\n");
        		continue;
        	}
        	
        	if(x == y || x == z || y == z) {
        		sb.append(IS).append("\n");
        		continue;
        	}
        	
        	sb.append(SC).append("\n");
        }

        System.out.println(sb.toString().trim());
	}

}
