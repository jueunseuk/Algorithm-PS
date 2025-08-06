package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3495_아스키도형 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int sum = 0;
        
        char input[];
        for(int i = 0; i < row; i++) {
        	input = br.readLine().toCharArray();
        	
        	int not = 0;
        	int prevIdx = 0;
        	for(int j = 0; j < col; j++) {
        		if(input[j] != '.') {
        			not++;
        			
        			if(not % 2 == 0) {
        				sum += j-prevIdx;
        			} else {
        				prevIdx = j;
        			}
        		}
        	}
        }
        
        System.out.println(sum);
	}
}