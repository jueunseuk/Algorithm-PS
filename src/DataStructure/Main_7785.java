package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main_7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String action = st.nextToken();
            
            if(action.equals("enter")) {
                set.add(name);
            } else if(action.equals("leave")) {
                set.remove(name);
            }
        }
        
        // HashSet을 리스트로 변환하여 정렬
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        
        // 결과 출력
        for(String name : list) {
            System.out.println(name);
        }
    }
}
