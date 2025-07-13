package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_25381_ABBC {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split("");
		
		Queue<Integer> aIdx = new ArrayDeque<>();
		Queue<Integer> bIdx = new ArrayDeque<>();
		Queue<Integer> cIdx = new ArrayDeque<>();
		
		int cnt = 0;
		
		// ABC의 인덱스 파악
		for(int i = 0; i < input.length; i++) {
			if(input[i].equals("A")) {
				aIdx.add(i);
			} else if(input[i].equals("B")) {
				bIdx.add(i);
			} else {
				cIdx.add(i);
			}
		}
		
		// BC 처리
		while(!bIdx.isEmpty() && !cIdx.isEmpty()) {
			// idx 값이 같을 일은 없음
			if(bIdx.peek() < cIdx.peek()) {
				input[bIdx.poll()] = "";
				input[cIdx.poll()] = "";
				cnt++;
			} else {
				cIdx.poll();
			}
		}
		
		// AB 처리
		while(!aIdx.isEmpty() && !bIdx.isEmpty()) {
			if(aIdx.peek() < bIdx.peek()) {
				input[aIdx.poll()] = "";
				input[bIdx.poll()] = "";
				cnt++;
			} else {
				bIdx.poll();
			}
		}
		
		System.out.println(cnt);
	}

}
