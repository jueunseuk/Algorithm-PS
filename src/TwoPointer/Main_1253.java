package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1253 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []input = new int[N];
		
		String []str = br.readLine().split(" ");
		for(int i = 0; i < N; i++) input[i] = Integer.parseInt(str[i]);
		Arrays.sort(input);
		
		int cnt = 0;
        for (int i = 0; i < N; i++) {
            int target = input[i];
            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = input[left] + input[right];
                if (sum == target) {
                    cnt++;
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
		
		System.out.println(cnt);
		
	}

}
