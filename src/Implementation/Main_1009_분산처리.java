package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1009_분산처리 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int down = Integer.parseInt(st.nextToken())%10;
			int up = Integer.parseInt(st.nextToken());
			
			if(down == 1) {
				System.out.println(1);
			} else if( down == 2) {
				if(up % 4 == 1) {
					System.out.println(2);
				} else if(up % 4 == 2) {
					System.out.println(4);
				} else if(up % 4 == 3) {
					System.out.println(8);
				} else {
					System.out.println(6);
				}
			} else if( down == 3) {
				if(up % 4 == 1) {
					System.out.println(3);
				} else if(up % 4 == 2) {
					System.out.println(9);
				} else if(up % 4 == 3) {
					System.out.println(7);
				} else {
					System.out.println(1);
				}
			} else if( down == 4) {
				if(up % 2 == 1) {
					System.out.println(4);
				} else {
					System.out.println(6);
				}
			} else if( down == 5) {
				System.out.println(5);
			} else if( down == 6) {
				System.out.println(6);
			} else if( down == 7) {
				if(up % 4 == 1) {
					System.out.println(7);
				} else if(up % 4 == 2) {
					System.out.println(9);
				} else if(up % 4 == 3) {
					System.out.println(3);
				} else {
					System.out.println(1);
				}
			} else if( down == 8) {
				if(up % 4 == 1) {
					System.out.println(8);
				} else if(up % 4 == 2) {
					System.out.println(4);
				} else if(up % 4 == 3) {
					System.out.println(2);
				} else {
					System.out.println(6);
				}
			} else if( down == 9) {
				if(up % 2 == 1) {
					System.out.println(9);
				} else {
					System.out.println(1);
				}
			} else {
				System.out.println(10);
			}
		}
	}

}
