package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_20240_IntegerRectangle {
	static final String MESSAGE = "Impossible";
	
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        preprocessing();

	}

	private static void preprocessing() {
		for(int i = 1; i <= 34; i++) {
			
		}
	}

	private static int calc(int i, int j) {
		return i*i+j*j;
	}

}
