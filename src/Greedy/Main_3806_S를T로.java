package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3806_S를T로 {
	static StringBuilder sb = new StringBuilder();
	static int idx = 1, cnt = 0;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
        	
        	char[] origin = br.readLine().toCharArray();
        	char[] target = br.readLine().toCharArray();
        	
        	StoT(target, origin);
        	
        	cnt = 0;
        }
        
        System.out.println(sb.toString().trim());
        
        br.close();
	}
	
	private static void StoT(char[] target, char[] origin) {
		int[] targetCnt = countingCnt(target);
		int[] originCnt = countingCnt(origin);
		
		if(originCnt[1] > targetCnt[1]) {
			makeAnswer(-1);
			return;
		}
		
		if(targetCnt[0] == originCnt[0] && targetCnt[1] == originCnt[1]) {
			swapCnt(target, origin);
			return;
		} else {
			if(targetCnt[0] - originCnt[0] > 0 && targetCnt[1] - originCnt[1] > 0) { // 둘 다 부족
				markToCombi(target, origin);
			} else if(targetCnt[0] - originCnt[0] > 0) { // 0의 개수만 부족
				markToZero(target, origin);
			} else if(targetCnt[1] - originCnt[1] > 0){ // 1의 개수만 부족
				markToOne(target, origin);
			}
		}
		
		originCnt = countingCnt(origin);
		
		swapCnt(target, origin);
		
	}
	

	private static void swapCnt(char[] target, char[] origin) {
		int dismatchZero = 0;
		int dismatchOne = 0;
		
		for(int i = 0; i < target.length; i++) {
			if(target[i] != origin[i]) {
				if(origin[i] == '0') {
					dismatchZero++;
				} else {
					dismatchOne++;
				}
			}
		}
		
		cnt += dismatchOne;
		cnt += dismatchZero - dismatchOne;
		
		makeAnswer(cnt);
	}
	
	private static void markToCombi(char[] target, char[] origin) {
		for(int i = 0; i < target.length; i++) {
			if(origin[i] == '?') {
				origin[i] = target[i];
				cnt++;
			}
		}
	}
	
	private static void markToOne(char[] target, char[] origin) {
		for(int i = 0; i < target.length; i++) {
			if(origin[i] == '?') {
				origin[i] = '1';
				cnt++;
			}
		}
	}

	private static void markToZero(char[] target, char[] origin) {
		for(int i = 0; i < target.length; i++) {
			if(origin[i] == '?') {
				origin[i] = '0';
				cnt++;
			}
		}
	}

	private static int[] countingCnt(char[] target) {
		int []result = new int[3];
		
		for(int i = 0; i < target.length; i++) {
			if(target[i] == '1') {
				result[1]++;
			} else if(target[i] == '0') {
				result[0]++;
			} else {
				result[2]++;
			}
		}
		
		return result;
	}


	public static void makeAnswer(int answer) {
		sb.append("Case ").append(idx++).append(": ").append(answer).append("\n");
	}
}
