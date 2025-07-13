package Sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_2108 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int number[] = new int[N];
		int sum = 0;
		double avg;
		int midNum;
		int length;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(br.readLine());
			sum += number[i];
			map.put(number[i], map.getOrDefault(number[i], 0)+1);
		}
		
		avg = (double) sum/N;
		Arrays.sort(number);
		midNum = number[N/2];
		length = number[number.length-1] - number[0];
		
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		
		list.sort((a, b)->{
			if(b.getValue().equals(a.getValue())) {
				return a.getKey().compareTo(b.getKey());
			} else {
				return b.getValue().compareTo(a.getValue());
			}
		});
		
		int mode = list.get(0).getKey();
		if (list.size() > 1 && list.get(0).getValue().equals(list.get(1).getValue())) {
            mode = list.get(1).getKey();
        }
		
		System.out.println(Math.round(avg));
		System.out.println(midNum);
		System.out.println(mode);
		System.out.println(length);
		
		
		
	}

}
