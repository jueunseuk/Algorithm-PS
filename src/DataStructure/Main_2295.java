package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main_2295 {
	static int[] result;
	static int input[];
	static int N;
	static Set<Integer> set;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        
        for(int i = 0; i < N; i++) {
        	input[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(input);
        
        set = new HashSet<>();
        result = new int[3];
        makeCombi(0, 0);
        
        for(int i = input.length-1; i >= 0; i--) {
        	if(set.contains(input[i])) {
        		System.out.println(input[i]);
        		return;
        	}
        }
        
	}
	private static void makeCombi(int depth, int idx) {
		if(depth == 3) {
			int sum = result[0]+result[1]+result[2];
			set.add(sum);
			return;
		}
		for(int i = idx; i < N; i++) {
			result[idx] = input[i];
			makeCombi(depth+1, idx+1);
		}
	}

}
