package Codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gender = Integer.parseInt(br.readLine());
        int age = Integer.parseInt(br.readLine());
        
        if(gender == 0) {
        		System.out.println(age >= 19 ? "MAN" : "BOY");
        } else {
        		System.out.println(age >= 19 ? "WOMAN" : "GIRL");        		
        }
	}
}