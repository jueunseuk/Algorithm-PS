package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1744_수묶기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> negative = new ArrayList<>();
		List<Integer> positive = new ArrayList<>();
		List<Integer> one = new ArrayList<>();
		List<Integer> zero = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input > 1) {
				positive.add(input);
			} else if(input < 0){
				negative.add(input);
			} else if(input == 1) {
				one.add(input);
			} else {
				zero.add(input);
			}
		}
		int posSize = positive.size();
		int negSize = negative.size();
		boolean isZero = !zero.isEmpty();
		boolean isOne = !one.isEmpty();
		
		int result = 0;
		Collections.sort(negative);
		Collections.sort(positive, Collections.reverseOrder());
		
		// 양수 처리
		for(int i = 0; i < posSize; i+=2) {
			if(i+1 < posSize) {
				result += positive.get(i)*positive.get(i+1);
			}
		}
		if(posSize % 2 == 1) {
			result += positive.get(posSize - 1);
		}
		
		// 음수 처리
		for(int i = 0; i < negSize; i+=2) {
			if(i+1 < negSize) {
				result += negative.get(i)*negative.get(i+1);
			}
		}
		if(negSize % 2 == 1 && !isZero) {
				result += negative.get(negSize-1);
		}
		
		if(isOne) {
			for(int out : one) {
				result += out;
			}			
		}
		
		System.out.println(result);
	}

}
