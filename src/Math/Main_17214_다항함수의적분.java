package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17214_다항함수의적분 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        
        StringBuilder result = new StringBuilder();
        
        // 0인 경우
        if(input.length() == 1 && input.charAt(0) == '0') {
        	System.out.println("W");
        	return;
        }
        
        // 1차식의 계수가 2인 경우
        if(input.charAt(0) == '2' && input.charAt(1) == 'x') {
        	result.append("xx");
        	
        	// 상수 없음
        	if(input.length() == 2) {
        		result.append("+W");
        		System.out.println(result.toString().trim());
        		return;
        	}
        	
        	int co = Integer.parseInt(input.substring(3, input.length()));
        	
        	// 계수가 1이나 -1인 경우는 따로 처리
        	if(co == 1 || co == -1) {
        		result.append(input.charAt(2)).append("x");
        	} else {
        		result.append(input.charAt(2)).append(co).append("x");
        	}
        	
        	result.append("+W");
        	System.out.println(result.toString().trim());
        	return;
        }
        
        // 1차식의 계수가 -2인 경우
        if(input.charAt(0) == '-' && input.charAt(1) == '2' && input.charAt(2) == 'x') {
        	result.append("-xx");
        	
        	// 상수 없음
        	if(input.length() == 3) {
        		result.append("+W");
        		System.out.println(result.toString().trim());
        		return;
        	}
        	
        	int co = Integer.parseInt(input.substring(4, input.length()));
        	
        	// 계수가 1이나 -1인 경우는 따로 처리
        	if(co == 1 || co == -1) {
        		result.append(input.charAt(3)).append("x");
        	} else {
        		result.append(input.charAt(3)).append(co).append("x");
        	}
        	
        	result.append("+W");
        	System.out.println(result.toString().trim());
        	return;
        }
        
        // x가 존재하는지 확인
        int idx = 0;
    	for(int i = 0; i < input.length(); i++) {
    		if(input.charAt(i) == 'x') {
    			idx = i;
    			break;
    		}
    	}
    	
    	// 상수만 존재하는 경우
    	if(idx == 0) {
    		int co = Integer.parseInt(input);
    		
    		if(co == 1) {
    			result.append("x");
    		} else if(co == -1) {
    			result.append("-x");
    		} else {
    			result.append(co).append("x");
    		}
    		
    		result.append("+W");
    		System.out.println(result.toString().trim());
    		return;
    	}
    	
    	// x가 존재하는 경우
    	int co = Integer.parseInt(input.substring(0, idx)) / 2;
    	
    	result.append(co).append("xx");
    	
    	// 상수 없음
    	if(input.length() - 1 == idx) {
    		result.append("+W");
    		System.out.println(result.toString().trim());
    		return;
    	}
    	
    	// 부호 추가
    	result.append(input.charAt(idx+1));
    	
    	int natural = Integer.parseInt(input.substring(idx+2, input.length()));
    	
    	// 1차항 추가
    	if(natural == 1) {
    		result.append("x");
    	} else if(natural == -1) {
    		result.append("-x");
    	} else {
    		result.append(natural).append("x");
    	}
    	
    	result.append("+W");
    	System.out.println(result.toString().trim());
    	
	}

}
