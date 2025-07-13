package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_1339_단어수학 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int []alpha = new int[26];
		
		for(int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            int length = input.length;
            int pow = 1;
            for(int j = length - 1; j >= 0; j--) {
                alpha[input[j] - 'A'] += pow;
                pow *= 10;
            }
        }
		
		Integer[] weights = new Integer[26];
        for (int i = 0; i < 26; i++) {
            weights[i] = alpha[i];
        }
        
        Arrays.sort(weights, Collections.reverseOrder());

        int sum = 0;
        int num = 9;
        for (int i = 0; i < 26; i++) {
            if (weights[i] == 0) break;
            sum += weights[i] * num;
            num--;
        }

        System.out.println(sum);
	}

}
