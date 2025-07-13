package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_11286_절댓값힙 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> positiveQ = new PriorityQueue<>();
		Queue<Integer> negativeQ = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input > 0) {
				positiveQ.add(input);
			} else if(input < 0) {
				negativeQ.add(input);
			} else {
				if(positiveQ.isEmpty() && negativeQ.isEmpty()) {
					System.out.println(0);
					continue;
				} else {
					if(positiveQ.isEmpty()) {
						System.out.println(negativeQ.isEmpty() ? 0 : negativeQ.poll());
					} else {
						if(negativeQ.isEmpty()) {
							System.out.println(positiveQ.poll());
						} else {
							int absN = Math.abs(negativeQ.peek());
							int absP = positiveQ.peek();
							
							if(absN <= absP) {
								System.out.println(negativeQ.poll());
							} else {
								System.out.println(positiveQ.poll());
							}
						}
					}
				}
			}
		}
	}
}