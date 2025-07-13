package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> al = new ArrayList<>();
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	String input = br.readLine();
        	StringTokenizer st = new StringTokenizer(input, " ");
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	
        	
        	al.add(A+B);
        }
        
        for(int i = 0; i < N; i++) {
        	System.out.println("Case #"+(i+1)+": "+al.get(i));
        }
        
    }
}
