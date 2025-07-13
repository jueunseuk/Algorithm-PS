package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15725_다항함수의미분 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        
        // 다항식의 계수가 1인 경우
        if(input.charAt(0) == 'x') {
        	System.out.println(1);
        	return;
        }
        
        // 계수가 -1인 경우
        if(input.charAt(0) == '-' && input.charAt(1) == 'x') {
        	System.out.println(-1);
        	return;
        }
        
        // x의 존재 여부 확인
    	int idx = 0;
    	for(int i = 0; i < input.length(); i++) {
    		if(input.charAt(i) == 'x') {
    			idx = i;
    			break;
    		}
    	}
    	
    	// x가 존재하지 않다면 바로 0 출력
    	if(idx == 0) {
    		System.out.println(0);
    		return;
    	}
    	
    	// x 존재
    	int co = Integer.parseInt(input.substring(0, idx));
    	System.out.println(co);
	}

}
