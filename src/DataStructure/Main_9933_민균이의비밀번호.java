package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_9933_민균이의비밀번호 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            String reverse = new StringBuilder(word).reverse().toString();
            
            if (set.contains(reverse) || word.equals(reverse)) {
                System.out.println(word.length() + " " + word.charAt(word.length() / 2));
                break;
            } else {
                set.add(word);
            }
        }
    }
}
