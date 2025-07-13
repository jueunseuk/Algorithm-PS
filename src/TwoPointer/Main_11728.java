package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int arrA[] = new int[A];
		int arrB[] = new int[B];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < A; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < B; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		int AB[] = new int[A+B];
		
		System.arraycopy(arrA, 0, AB, 0, A);
        System.arraycopy(arrB, 0, AB, A, B);
        
        Arrays.sort(AB);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < AB.length; i++) {
            sb.append(AB[i]).append(' ');
        }
        
        System.out.println(sb.toString().trim());
	}

}
