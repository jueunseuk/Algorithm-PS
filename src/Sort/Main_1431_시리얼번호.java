package Sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_1431_시리얼번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(br.readLine());
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length()) {
					return o1.length()-o2.length();
				} else {
					String[]arr1 = o1.split("");
					String[]arr2 = o2.split("");
					int sum1 = 0, sum2 = 0;
					for(int i = 0; i < arr1.length; i++) {
						try {
							sum1 += Integer.parseInt(arr1[i]);
						} catch (NumberFormatException e) {
							continue;
						}
					}
					for(int i = 0; i < arr2.length; i++) {
						try {
							sum2 += Integer.parseInt(arr2[i]);
						} catch (NumberFormatException e) {
							continue;
						}
					}
					if(sum1 < sum2) {
						return -1;
					} else if (sum1 > sum2){
						return 1;
					} else {
						return o1.compareTo(o2);
					}
				}
			}
		});
		
		for(String out : list) {
			System.out.println(out);
		}
		
		br.close();
	}

}
