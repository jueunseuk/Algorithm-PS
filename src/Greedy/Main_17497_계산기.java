package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17497_계산기 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());
        
        int cnt = 0;
        while(n > 0) {
        	if(cnt > 100) {
        		System.out.println(-1);
        		return;
        	}
        	
        	if(n == 2) {
        		cnt++;
        		concatPlus();
        		break;
        	}
        	
        	if(n % 2 == 0) {
        		if((n/2) % 2 == 0) {
        			n /= 2;
        			concatMulti();
        			cnt++;
        		} else {
        			n += 2;
        			concatMinus();
        			n /= 2;
        			concatMulti();
        			cnt += 2;
        		}
        	} else {
        		n *= 2;
        		concatDiv();
        		n += 2;
        		concatMinus();
        		n /= 2;
        		concatMulti();
        		cnt += 3;
        	}
        }
        
        System.out.println(cnt);
        System.out.println(sb.reverse().toString().trim());
	}

	private static void concatMulti() {
		sb.append("]*[").append(" ");
	}
	private static void concatDiv() {
		sb.append("]/[").append(" ");
	}
	private static void concatPlus() {
		sb.append("]+[").append(" ");
	}
	private static void concatMinus() {
		sb.append("]-[").append(" ");
	}
}
