package Bruteforce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1065 {
	
	static int N, cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        
		genHan(1);
		System.out.println(cnt);
		
	}
	
	public static void genHan(int number) {
		if(number > N) return;
		
		List<Integer> list = new ArrayList<>();
		int temp = number;
		while(temp != 0) {
			list.add(temp%10);
			temp /= 10;
		}
		
		if (list.size() < 3) {
            cnt++;
        } else {
            int diff = list.get(1) - list.get(0);
            boolean isHan = true;
            for (int i = 2; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 1) != diff) {
                    isHan = false;
                    break;
                }
            }
            if (isHan) {
                cnt++;
            }
        }
		genHan(number+1);
	}
	
}
