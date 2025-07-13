package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_32143_카드게임 {
	static Queue<Long> q = new PriorityQueue<>();
	static long HP, currentSum = 0;
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HP = Long.parseLong(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int original = Integer.parseInt(st.nextToken());
        int additional = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < original; i++) {
        	long input = Long.parseLong(st.nextToken());
        	currentSum += input;
        	q.add(input);
        }
        
        result.append(getSize()).append("\n");
        
        for(int i = 0; i < additional; i++) {
        	long input = Long.parseLong(br.readLine());
        	
        	if(currentSum >= HP && input <= q.peek()) {
        		result.append(getSize()).append("\n");
        		continue;
        	}
        	
        	currentSum += input;
        	q.add(input);
        	
        	result.append(getSize()).append("\n");
        }
        
        System.out.println(result.toString().trim());
	}
	
	public static int getSize() {
		if(currentSum < HP) {
			return -1;
		}
		
		while(true) {
			if(currentSum - q.peek() < HP) {
				break;
			} else {
				currentSum -= q.poll();
			}
		}
		
		return q.size();
	}

}
