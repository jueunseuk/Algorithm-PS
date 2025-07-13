package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_6068_시간관리하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		int[][] input = new int[t][2];
		
		StringTokenizer st;
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o2[1], o1[1]);
			}
			
		});
		
		int idxTime = input[0][1];
        
        for (int i = 0; i < t; i++) {
            int timeRequired = input[i][0];
            int deadline = input[i][1];
            
            if (idxTime > deadline) {
            	idxTime = deadline;
            }
            
            idxTime -= timeRequired;
            
            if (idxTime < 0) {
                System.out.println(-1);
                return;
            }
        }
		
		System.out.println(idxTime);
		
		br.close();
		
	}

}
