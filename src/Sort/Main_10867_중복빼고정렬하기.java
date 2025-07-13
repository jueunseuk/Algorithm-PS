package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_10867_중복빼고정렬하기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < n; i++) {
        	set.add(Integer.parseInt(st.nextToken()));
        }
        
        List<Integer> list = new ArrayList<>(set);
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for(int out : list) {
        	sb.append(out).append(" ");
        }
        
        System.out.println(sb.toString().trim());
	}

}
