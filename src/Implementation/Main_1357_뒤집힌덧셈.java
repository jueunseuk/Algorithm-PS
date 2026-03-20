package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1357_뒤집힌덧셈 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder a = new StringBuilder(st.nextToken());
        StringBuilder b = new StringBuilder(st.nextToken());
        int sum = Integer.parseInt(a.reverse().toString()) + Integer.parseInt(b.reverse().toString());
        StringBuilder c = new StringBuilder(String.valueOf(sum));
        System.out.println(Integer.parseInt(c.reverse().toString().trim()));
	}
}