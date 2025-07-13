package PrefixSum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16139_인간컴퓨터상호작용 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] str = br.readLine().toCharArray();
        int[][] sum = new int[26][str.length];
        sum[str[0]-'a'][0]++;
        
        int query = Integer.parseInt(br.readLine());
        
        int length = str.length;
        for(int i = 1; i < length; i++) {
        	int target = str[i] - 'a';
        	for(int j = 0; j < 26; j++) {
        		if(target != j) {
        			sum[j][i] += sum[j][i-1];
        		} else {
        			sum[j][i] += sum[j][i-1]+1;
        		}
        	}
        }

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < query; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int target = st.nextToken().charAt(0) - 'a';
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	if(start == 0) {
        		sb.append(sum[target][end]+"\n");
        	} else {
        		sb.append(sum[target][end]-sum[target][start-1]).append("\n");
        	}
        }
        
        System.out.println(sb.toString().trim());
	}
}