package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2531_회전초밥 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		// line 1 input
		st = new StringTokenizer(reader(), " ");
		int dish = Integer.parseInt(st.nextToken());
		int sushi = Integer.parseInt(st.nextToken());
		int kkk = Integer.parseInt(st.nextToken());
		int coupone = Integer.parseInt(st.nextToken());
		
		// left input
		st = new StringTokenizer(reader(), " ");
		int kind[] = new int[dish];
		for(int i = 0; i < dish; i++) {
			kind[i] = Integer.parseInt(st.nextToken());
		}
		
	}
	
	// input method
	public static String reader() throws IOException{
		return br.readLine();
	}
	
}
