package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1297_TV크기 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine() ," ");
        double diagonal = Double.parseDouble(st.nextToken());
        double w = Double.parseDouble(st.nextToken());
        double h = Double.parseDouble(st.nextToken());
        
        double d = Math.sqrt(w*w+h*h);
        double div = diagonal / d;
        
        System.out.println((int)Math.floor(w*div)+" "+(int)Math.floor(h*div));
	}
}