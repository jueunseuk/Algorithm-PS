package Bruteforce;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2670_연속부분최대곱 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        double[] input = new double[n];
        
        for (int i = 0; i < n; i++) {
            input[i] = Double.parseDouble(br.readLine());
        }
        
        double max = input[0];
        double currentMax = input[0];
        
        for (int i = 1; i < n; i++) {
            currentMax = Math.max(currentMax * input[i], input[i]);
            max = Math.max(max, currentMax);
        }
        
        System.out.printf("%.3f", max);
    }
}
