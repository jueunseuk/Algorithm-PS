package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1358_하키 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int people = Integer.parseInt(st.nextToken());
        int r = (h/2);
        int rr = (h/2)*(h/2);
        
        int cnt = 0;
        for(int i = 0; i < people; i++) {
        	st = new StringTokenizer(br.readLine());
        	int nx = Integer.parseInt(st.nextToken());
        	int ny = Integer.parseInt(st.nextToken());
        	
        	double distance1 = (nx-x)*(nx-x)+(y+r-ny)*(y+r-ny);
        	double distance2 = (x+w-nx)*(x+w-nx)+(y+r-ny)*(y+r-ny);
        	
        	if(nx >= x && nx <= x+w && ny >= y && ny <= y+h) {
        		cnt++;
        	} else if(distance1 <= rr || distance2 <= rr) {
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
        
	}

}
