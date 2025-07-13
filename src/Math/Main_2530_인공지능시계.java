package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2530_인공지능시계 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		
		m += n / 60;
		s += n % 60;
		
		m += s / 60;
		s %= 60;
		
		h += m / 60;
		m %= 60;
		
		h %= 24;
		
		System.out.println(h+" "+m+" "+s);
	}
}