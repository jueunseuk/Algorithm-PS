package TwoPointer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        int []input = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = N-1;
        int shortLength = N;
        
        while(left < right) {
        	int currentSum = 0;
        	for(int i = left; i <= right; i++) {
        		currentSum += input[i];
        	}
        	
        	if(currentSum > S) {
        		if(input[left+1]<input[right-1]) {
        			left++;
        			shortLength--;
        		}
        		else {
        			right--;
        			shortLength--;
        		}
        	}
        	else {
        		break;
        	}
        }
        
        System.out.println(shortLength);
	}

}
