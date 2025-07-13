package GameTheory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16895_님게임3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];

		int result = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			result ^= input[i];
		}

		if (result == 0) {
			System.out.println(0);
		} else {
			int answer = 0;
			for (int i = 0; i < N; i++) {
				result = 0;

				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}

					result ^= input[j];
				}

				for (int j = input[i] - 1; j >= 0; j--) {
					int temp = result;

					if ((temp ^= j) == 0) {
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}

}