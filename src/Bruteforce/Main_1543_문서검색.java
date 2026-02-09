package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1543_문서검색 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();
        String word = br.readLine();

        int cnt = 0;
        for(int i = 0; i <= doc.length() - word.length();) {
            if (doc.startsWith(word, i)) {
                cnt++;
                i += word.length();
            } else {
                i++;
            }
        }

        System.out.println(cnt);
    }
}