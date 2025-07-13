package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_30802 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int size[] = new int[6];
		
		for(int i = 0; i < 6; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int set[] = new int[2];
		set[0] = Integer.parseInt(st.nextToken());
		set[1] = Integer.parseInt(st.nextToken());
		
		int result[] = new int[3];
		for(int i = 0 ; i< 6; i++) {
			
			if(size[i]%set[0] == 0) {
				result[0]+=size[i]/set[0];
			} else {
				result[0]+=size[i]/set[0]+1;				
			}
		}
		
		result[1] = N/set[1];
		result[2] = N%set[1];
		
		System.out.println(result[0]);
		System.out.println(result[1]+" "+result[2]);
		
	}

}
