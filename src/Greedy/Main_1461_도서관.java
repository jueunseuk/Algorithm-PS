package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1461_도서관 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<Integer> right	= new ArrayList<>();
        List<Integer> left	= new ArrayList<>();
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	int input = Integer.parseInt(st.nextToken());
        	if(input > 0) {
        		right.add(input);
        	} else {
        		left.add(-input);
        	}
        }
        
        Collections.sort(right, Collections.reverseOrder());
        Collections.sort(left, Collections.reverseOrder());
        
        int sum = 0;
        int rightLength = right.size();
        int leftLength = left.size();
        
        for(int i = 0; i < rightLength; i+=m) {
        	sum += right.get(i)*2;
        }
        for(int i = 0; i < leftLength; i+=m) {
        	sum += left.get(i)*2;
        }
        
        if(right.isEmpty()) {
        	sum -= left.get(0);
        } else {
        	if(left.isEmpty()) {
        		sum -= right.get(0);
        	} else {
        		if(right.get(0) > left.get(0)) {
                	sum -= right.get(0);
                } else {
                	sum -= left.get(0);
                }
        	}
        }
        
        System.out.println(sum);
	}

}
