package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_24524_아름다운문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        Map<Character, Integer> sFreq = calculateFrequency(S);
        Map<Character, Integer> tFreq = calculateFrequency(T);

        int cnt = Integer.MAX_VALUE;
        for (char c : T.toCharArray()) {
            if (!sFreq.containsKey(c)) {
                cnt = 0;
                break;
            }
            int possibleCount = sFreq.get(c) / tFreq.get(c);
            cnt = Math.min(cnt, possibleCount);
        }

        System.out.println(cnt);
    }

    private static Map<Character, Integer> calculateFrequency(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }
}
