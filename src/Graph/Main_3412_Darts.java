package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3412_Darts {
	static final int[] arr = {400, 1600, 3600, 6400, 10000, 14400, 19600, 25600, 32400, 40000};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); 
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	int n = Integer.parseInt(br.readLine());
        	int sum = 0;
        	for(int i = 0; i < n; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int calc = calc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        		
        		for(int j = 0; j < 10; j++) {
        			if(calc <= arr[j]) {
        				sum += 10-j;
        				break;
        			}
        		}
        	}
        	sb.append(sum).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
	
	public static int calc(int x1, int y1) {
		return x1*x1 + y1*y1;
	}
}