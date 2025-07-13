package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_2608_로마숫자 {
    static String[] runtime = new String[4000];
    static Map<String, Integer> romanToArabic = new HashMap<>();
    static int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        initializeRomanMapping();

        int a = romanToArabic(br.readLine());
        int b = romanToArabic(br.readLine());
        System.out.println(a+b);
        
        System.out.println(arabicToRoman(a+b));
    }

    private static void initializeRomanMapping() {
        romanToArabic.put("I", 1);
        romanToArabic.put("IV", 4);
        romanToArabic.put("V", 5);
        romanToArabic.put("IX", 9);
        romanToArabic.put("X", 10);
        romanToArabic.put("XL", 40);
        romanToArabic.put("L", 50);
        romanToArabic.put("XC", 90);
        romanToArabic.put("C", 100);
        romanToArabic.put("CD", 400);
        romanToArabic.put("D", 500);
        romanToArabic.put("CM", 900);
        romanToArabic.put("M", 1000);
    }

    private static String arabicToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < arabicValues.length; i++) {
            while (num >= arabicValues[i]) {
                roman.append(romanSymbols[i]);
                num -= arabicValues[i];
            }
        }
        return roman.toString();
    }

    private static int romanToArabic(String roman) {
        int sum = 0;
        int i = 0;
        while (i < roman.length()) {
            if (i + 1 < roman.length() && romanToArabic.containsKey(roman.substring(i, i + 2))) {
                sum += romanToArabic.get(roman.substring(i, i + 2));
                i += 2;
            } else {
                sum += romanToArabic.get(roman.substring(i, i + 1));
                i++;
            }
        }
        return sum;
    }
}
