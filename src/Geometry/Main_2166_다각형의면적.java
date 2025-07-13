package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2166_다각형의면적 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int []x = new int[n+1];
		int y[] = new int[n+1];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		x[n] = x[0];
		y[n] = y[0];
		
		double sum1 = 0, sum2 = 0;
        for(int i = 0; i < n; i++) {
            sum1 += (double)x[i] * y[i + 1];
            sum2 += (double)y[i] * x[i + 1];
        }

        double area = Math.abs(sum1 - sum2) / 2.0;
        System.out.printf("%.1f\n", area);
	}

}
