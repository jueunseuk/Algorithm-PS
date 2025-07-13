package Sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_18870_좌표압축하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(num);
			set.add(num);
		}
		
		
		List<Integer> sortList = new ArrayList<>(set);
		Collections.sort(sortList);
		
		HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        for (int num : sortList) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }
		
		StringBuilder sb = new StringBuilder();
		
		for (int num : list) {
            sb.append(map.get(num)).append(" ");
        }

		System.out.println(sb.toString().trim());
		
	}

}
