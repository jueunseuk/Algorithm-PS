package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_11653 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		
        
		for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                list.add(i);
                N /= i;
            }
        }
		
		if (N > 1) {
            list.add(N);
        }
		
        for(int i = 0; i< list.size(); i++) {
        	System.out.println(list.get(i));
        }
        
        br.close();
	}

}
