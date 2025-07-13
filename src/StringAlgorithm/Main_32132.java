package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_32132 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 64);
		int N = Integer.parseInt(br.readLine());
		
		String result[] = br.readLine().split("");
		
		for(int i = 0; i < N-2; i++) {
			if(result[i].equals("P")){
				if(result[i+1].equals("S")) {
					int j = i+2;
					while(j < N) {
						if(result[j].equals("4") || result[j].equals("5")) {
							result[j] = "";
							j++;
						} else break;
					}
				}
			}
		}
	
		for(String out : result)
		System.out.print(out);
	}

}
