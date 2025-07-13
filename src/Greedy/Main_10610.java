package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10610 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int size = str.length();
        
        int[] numArr = new int[size];
        for (int i = 0; i < size; i++) {
            numArr[i] = str.charAt(i) - '0';
        }
        
        Arrays.sort(numArr);
        
        if (numArr[0] != 0) {
            System.out.println(-1);
            return;
        }
        
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += numArr[i];
        }
        
        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            sb.append(numArr[i]);
        }
        
        System.out.println(sb);
    }
}
