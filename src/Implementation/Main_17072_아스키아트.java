package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17072_아스키아트 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	for(int j = 0; j < col; j++) {
        		sb.append(func(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString().trim());

	}

	private static char func(int a, int b, int c) {
		int sum = 2126*a + 7152*b + 722*c;
		
		if(0 <= sum && sum < 510000) {
			return '#';
		} else if(510000 <= sum && sum < 1020000) {
			return 'o';
		} else if(1020000 <= sum && sum < 1530000) {
			return '+';
		} else if(1530000 <= sum && sum < 2040000) {
			return '-';
		} else {
			return '.';
		}
	}

}
