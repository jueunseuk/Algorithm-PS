package DivideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_4779_칸토어집합 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        while(true) {
        	int n;
        	try {
				n = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				break;
			}
        	
        	sb.append(recursion(n)).append("\n");        	
        }

        System.out.println(sb.toString().trim());
	}

	public static String recursion(int depth) {
	    if (depth == 0) {
	        return "-";
	    }

	    String prev = recursion(depth - 1);

	    StringBuilder space = new StringBuilder();
	    for (int i = 0; i < prev.length(); i++) {
	        space.append(" ");
	    }

	    return prev + space.toString() + prev;
	}
}