package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_10101_삼각형외우기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Set<Integer> set = new HashSet<>();
        
        int sum = 0;
        for(int i = 0; i < 3; i++) {
        	int input = Integer.parseInt(br.readLine());
        	
        	set.add(input);
        	sum += input;
        }

        if(sum == 180) {
        	if(set.size() == 1) {
        		System.out.println("Equilateral");
        	} else if(set.size() == 2) {
        		System.out.println("Isosceles");
        	} else {
        		System.out.println("Scalene");
        	}
        } else {
        	System.out.println("Error");
        }
	}

}
