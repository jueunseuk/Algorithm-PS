package Preprocessing;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_26495_BigNumber {
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split("");
        
        for(int i = 0; i < input.length; i++) {
        	switch(input[i]) {
	        	case "1":{
	        		result.append(one()).append("\n");
	        		break;
	        	}
	        	case "2":{
	        		result.append(two()).append("\n");
	        		break;
	        	}
	        	case "3":{
	        		result.append(three()).append("\n");
	        		break;
	        	}
	        	case "4":{
	        		result.append(four()).append("\n");
	        		break;
	        	}
	        	case "5":{
	        		result.append(five()).append("\n");
	        		break;
	        	}
	        	case "6":{
	        		result.append(six()).append("\n");
	        		break;
	        	}
	        	case "7":{
	        		result.append(seven()).append("\n");
	        		break;
	        	}
	        	case "8":{
	        		result.append(eight()).append("\n");
	        		break;
	        	}
	        	case "9":{
	        		result.append(nine()).append("\n");
	        		break;
	        	}
	        	case "0":{
	        		result.append(zero()).append("\n");
	        		break;
	        	}
        	}
        	if(i < input.length-1)
        	result.append("\n");
        }
        
        System.out.println(result.toString());
	}

	public static String one() {
		String str = "   1\n   1\n   1\n   1\n   1";
		return str;
	}
	
	public static String two() {
		String str = "2222\n   2\n2222\n2\n2222";
		return str;
	}
	
	public static String three() {
		String str = "3333\n   3\n3333\n   3\n3333";
		return str;
	}
	
	public static String four() {
		String str = "4  4\n4  4\n4444\n   4\n   4";
		return str;
	}
	
	public static String five() {
		String str = "5555\n5\n5555\n   5\n5555";
		return str;
	}
	
	public static String six() {
		String str = "6666\n6\n6666\n6  6\n6666";
		return str;
	}
	
	public static String seven() {
		String str = "7777\n   7\n   7\n   7\n   7";
		return str;
	}
	
	public static String eight() {
		String str = "8888\n8  8\n8888\n8  8\n8888";
		return str;
	}
	
	public static String nine() {
		String str = "9999\n9  9\n9999\n   9\n   9";
		return str;
	}
	
	public static String zero() {
		String str = "0000\n0  0\n0  0\n0  0\n0000";
		return str;
	}
}