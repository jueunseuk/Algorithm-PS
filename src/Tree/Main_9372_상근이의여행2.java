package Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9372_상근이의여행2 {
	static int n, m;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());

        	for(int i = 0; i < m; i++) {
        		br.readLine();
        	}
        	
        	sb.append(n-1+"\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}