package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main_2484 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int result[] = new int[N];
		int number[] = new int[4];
		
		
		for(int i = 0 ; i < N; i++) {
			String[] str = br.readLine().split(" ");
			Set<Integer> set = new HashSet<>();
			
			for(int j = 0; j < 4; j++) {
				number[j] = Integer.parseInt(str[j]);
				set.add(number[j]);
			}
			Arrays.sort(number);
			
			List<Integer> list = new ArrayList<>(set);
			Collections.sort(list);
			
			switch(set.size()) {
				case 1 : {
					result[i] = 50000+number[0]*5000;
					break;
				}
				case 2 : {
					if(number[1]==number[2])
						result[i] = 10000+number[1]*1000;
					else result[i] = 2000+number[0]*500+number[3]*500;
					break;
				}
				case 3 : {
					if(number[0]==number[1])
						result[i] = 1000+number[0]*100;
					else if(number[1]==number[2])
						result[i] = 1000+number[1]*100;
					else result[i] = 1000+number[2]*100;
					break;
				}
				case 4 : {
					result[i] = number[3]*100;
					break;
				}
			}//switch
			
		}//for
		
		Arrays.sort(result);
		System.out.println(result[N-1]);
		
		
	}

}
