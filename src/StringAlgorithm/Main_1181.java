package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main_1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < N; i++) {
        	set.add(br.readLine());
        }
        
        List<String> list = new ArrayList<>(set);
        int clone[] = new int[list.size()];
        
        for(int i = 0; i < clone.length; i++) clone[i] = list.get(i).length();
        
	}

}
