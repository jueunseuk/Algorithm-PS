package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_12919_A와B2 {
    static String input;
    static boolean isPossible = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        String target = br.readLine();

        dfs(target);

        System.out.println(isPossible ? 1 : 0);
    }

    public static void dfs(String current) {
        if (current.equals(input)) {
            isPossible = true;
            return;
        }

        if (current.length() < input.length() || isPossible) {
            return;
        }

        if (current.charAt(current.length() - 1) == 'A') {
            dfs(current.substring(0, current.length() - 1));
        }

        if (current.charAt(0) == 'B') {
            dfs(new StringBuilder(current.substring(1)).reverse().toString());
        }
    }
}
