package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> setA = new HashSet<>();
		Set<String> setB = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			setA.add(br.readLine());
		}
		for(int i = 0; i < M; i++) {
			setB.add(br.readLine());
		}
		
		setA.retainAll(setB);
		
		List<String> list = new ArrayList<>(setA);
		Collections.sort(list);
		
		System.out.println(setA.size());
		for(String out : list) {
			System.out.println(out);
		}
		
	}

}
