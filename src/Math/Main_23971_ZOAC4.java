package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_23971_ZOAC4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int gRow = Integer.parseInt(st.nextToken())+1;
		int gCol = Integer.parseInt(st.nextToken())+1;
		
		if(row % gRow == 0) {
			int ans1 = row/gRow;
			if(col % gCol == 0) {
				System.out.println(ans1*(col/gCol));
			} else {
				System.out.println(ans1*(col/gCol+1));
			}
		} else {
			int ans1 = row/gRow+1;
			if(col % gCol == 0) {
				System.out.println(ans1*(col/gCol));
			} else {
				System.out.println(ans1*(col/gCol+1));
			}
		}

	}

}
