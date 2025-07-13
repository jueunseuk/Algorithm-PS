package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main_1181_단어정렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < N ; i++) {
			set.add(br.readLine());
		}
		
		List<String> list = new ArrayList<>(set);
		
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				int lengthComp = Integer.compare(a.length(), b.length());
				
				if(lengthComp != 0) {
					return lengthComp;
				}
				
				int charComp = a.compareTo(b);
				return charComp;
			}
			
		};
		
		Collections.sort(list, comparator);
		
		for(String out : list)
		System.out.println(out);
	}

}
