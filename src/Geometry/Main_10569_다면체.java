package Geometry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10569_다면체 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	sb.append(-(Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken())-2)).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}