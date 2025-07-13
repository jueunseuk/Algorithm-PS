package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17286_유미 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        double start[] = new double[2];
        double pos[][] = new double[3][2];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < 3; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	pos[i][0] = Integer.parseInt(st.nextToken());
        	pos[i][1] = Integer.parseInt(st.nextToken());
        }
        
        double s_z = calc(start[0], start[1], pos[0][0], pos[0][1]);
        double s_o = calc(start[0], start[1], pos[1][0], pos[1][1]);
        double s_t = calc(start[0], start[1], pos[2][0], pos[2][1]);
        
        double z_o = calc(pos[0][0], pos[0][1], pos[1][0], pos[1][1]);
        double o_t = calc(pos[2][0], pos[2][1], pos[1][0], pos[1][1]);;
        double z_t = calc(pos[0][0], pos[0][1], pos[2][0], pos[2][1]);;
        
        double result[] = new double[6];
        
        result[0] = s_z + z_o + o_t;
        result[1] = s_z + z_t + o_t;
        
        result[2] = s_o + o_t + z_t;
        result[3] = s_o + z_o + z_t;
        
        result[4] = s_t + o_t + z_o;
        result[5] = s_t + z_t + z_o;
        
        double min = Double.MAX_VALUE;
        for(int i = 0; i < 6; i++) {
        	min = Math.min(min, result[i]);
        }
        
        System.out.println((int) min);
	}
	
	public static double calc(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	}

}
