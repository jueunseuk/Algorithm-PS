package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_2870_수학숙제 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            
            for(char ch : input) {
                if(ch >= '0' && ch <= '9') {
                    sb.append(ch);
                } else {
                    if(sb.length() > 0) {
                        list.add(sb.toString());
                        sb.setLength(0);
                    }
                }
            }
            
            if(sb.length() > 0) {
                list.add(sb.toString());
            }
        }
        
        for(int i = 0; i < list.size(); i++) {
            list.set(i, deleteZero(list.get(i)));
        }
        
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(String num : list) {
            sb.append(num).append("\n");
        }
        System.out.print(sb);
    }

    public static String deleteZero(String str) {
        int idx = 0;
        while(idx < str.length() && str.charAt(idx) == '0') {
            idx++;
        }
        if(idx == str.length()) {
            return "0";
        }
        return str.substring(idx);
    }
}
