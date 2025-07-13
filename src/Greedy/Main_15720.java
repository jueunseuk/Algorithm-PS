package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15720 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int B = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int saleCnt = Math.min(B, Math.min(S, D));
		
		int burger[] = new int[B];
		int side[] = new int[S];
		int drink[] = new int[D];
		int originPrice = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < B; i++) {
			burger[i] = Integer.parseInt(st.nextToken());
			originPrice += burger[i];
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < S; i++) {
			side[i] = Integer.parseInt(st.nextToken());
			originPrice += side[i];
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < D; i++) {
			drink[i] = Integer.parseInt(st.nextToken());
			originPrice += drink[i];
		}
		
		Arrays.sort(burger);
		Arrays.sort(side);
		Arrays.sort(drink);
		
		System.out.println(originPrice);
		
		for(int i = 0; i < saleCnt; i++) {
			originPrice -= burger[burger.length-i-1]*0.1;
			originPrice -= side[side.length-i-1]*0.1;
			originPrice -= drink[drink.length-i-1]*0.1;
		}
		
		System.out.println(originPrice);
		
	}

}
