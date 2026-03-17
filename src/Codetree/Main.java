package Codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        String b = st.nextToken();
        
        if(a.length() == b.length()) {
        	System.out.println("same");
        } else {
        	System.out.println(a.length() > b.length() ? a+" "+a.length() : b+" "+b.length());
        }
	}
}