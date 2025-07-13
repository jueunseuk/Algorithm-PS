package TwoPointer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int right = N-1;
        int left = 0;
        int sum = Integer.MAX_VALUE;
        int answerLeft = 0;
        int answerRight = 0;
        int []input = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(input);
        while(right>left) {
        	int currnetSum = input[right]+input[left];
        	if(Math.abs(sum)>Math.abs(currnetSum)) {
        		sum = currnetSum;
        		answerLeft = input[left];
        		answerRight = input[right];
        	}
        	
        	if(currnetSum > 0) {
        		right--;
        	}
        	else if(currnetSum < 0) {
        		left++;
        	}
        	else {
        		break;
        	}
        	
        }
        System.out.println(answerLeft+" "+answerRight);
        
	}

}
