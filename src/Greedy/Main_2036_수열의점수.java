package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_2036_수열의점수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int cntZero = 0;
		int cntOne = 0;
		Queue<Integer> negaQ = new PriorityQueue<>();
		Queue<Integer> posiQ = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input > 1) {
				posiQ.add(input);
			} else if(input < 0) {
				negaQ.add(input);
			} else if(input == 1) {
				cntOne++;
			} else {
				cntZero++;
			}
		}
		
		br.close();
		
		long result = 0;
		
		// 양수부터 처리
		while(!posiQ.isEmpty()) {
			if(posiQ.size() > 1) {
				result += (long) posiQ.poll()*posiQ.poll();
			} else {
				result += posiQ.poll();
			}
		}
		
		// 1처리
		result += cntOne;
		
		// 음수처리
		while(negaQ.size() > 1) {
			result += (long) negaQ.poll()*negaQ.poll();
		}
		
		// 남은 음수와 0 동시에 처리
		if(!negaQ.isEmpty()) {
			if(cntZero == 0) {
				result += negaQ.poll();
			}
		}
		
		System.out.println(result);
	}

}
