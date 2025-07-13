package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_5597 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
				
		for(int i = 0; i < 28; i++) list.add(Integer.parseInt(br.readLine()));
		
		for(int i = 1; i <= 30; i++) {
			if(!list.contains(i)) {
				System.out.println(i);
			}
		}
	}
}
