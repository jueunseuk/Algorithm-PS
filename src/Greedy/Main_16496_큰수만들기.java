package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_16496_큰수만들기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = st.nextToken();
        }

        Arrays.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String xy = o1 + o2;
                String yx = o2 + o1;
                return yx.compareTo(xy);
            }
        });
        
        StringBuilder result = new StringBuilder();
        for (String num : numbers) {
            result.append(num);
        }

        if (result.charAt(0) == '0') {
            System.out.println("0");
        } else {
            System.out.println(result.toString());
        }
    }
}
