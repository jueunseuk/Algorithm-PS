package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9243_파일완전삭제 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()) % 2;
		char[] input = br.readLine().toCharArray();
		char[] input2 = br.readLine().toCharArray();
		
		int length = input.length;
		
		boolean flag = true;
		if(n == 0) {
			for(int i = 0; i < length; i++) {
				if(input[i] != input2[i]) {
					flag = false;
				}
			}
		} else {
			for(int i = 0; i < length; i++) {
				if(input[i] == input2[i]) {
					flag = false;
				}
			}
		}
		
		System.out.println(flag ? "Deletion succeeded" : "Deletion failed");
	}

}
