package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1614_영식이의손가락 {
	static final int CYCLE = 8;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int hurt = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        
        int result = 0;
        switch(hurt) {
	        case 1: {
        		result = CYCLE * count;
	        	break;
	        }
	        case 2: {
	        	if(count % 2 == 0) {
	        		result = CYCLE * count / 2 + 1;
	        	} else {
	        		result = CYCLE * (count-1) / 2 + 7;
	        	}
	        	break;
	        }
	        case 3: {
	        	if(count % 2 == 0) {
	        		result = CYCLE * count / 2 + 2;
	        	} else {
	        		result = CYCLE * (count-1) / 2 + 6;
	        	}
	        	break;
	        }
	        case 4: {
	        	if(count % 2 == 0) {
	        		result = CYCLE * count / 2 + 3;
	        	} else {
	        		result = CYCLE * (count-1) / 2 + 5;
	        	}
	        	break;
	        }
	        case 5: {
	        	result = CYCLE * count + 4;
	        	break;
	        }
        }

        System.out.println(result);
	}
}