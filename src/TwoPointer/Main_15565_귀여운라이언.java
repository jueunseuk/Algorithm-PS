package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15565_귀여운라이언 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken()); // 라이언
        int m = Integer.parseInt(st.nextToken());
        
        List<Integer> list = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n; i++) {
        	if(st.nextToken().equals("1"))
        		list.add(i); // 1인 인덱스만 저장        		
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size()-m+1; i++) {
        	min = Math.min(min, list.get(i+m-1) - list.get(i) + 1);
        }
        
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        br.close();
	}

}
