package Sort;
import java.util.Arrays;

public class Main_2752_세수 {

	public static void main(String[] args) throws Exception {
		
		int n[] = new int[3];
		
		n[0] = read();
		n[1] = read();
		n[2] = read();
		
		Arrays.sort(n);
		
		System.out.println(n[0]+" "+n[1]+" "+n[2]);
	}
	
	public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

}
