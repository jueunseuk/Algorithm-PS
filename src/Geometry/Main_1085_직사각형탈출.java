package Geometry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1085_직사각형탈출 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		
		int coor[] = new int[] {Integer.parseInt(input[0]),Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3])};
		
		int result = Math.min(Math.min(coor[2]-coor[0], coor[0]), Math.min(coor[3]-coor[1], coor[1]));
		System.out.println(result);
	}

}
