package DataGeneration;

public class Main_181114 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= 5000; i++) {
			sb.append(i+" ");
		}
		
		sb.deleteCharAt(sb.length()-1);
	}
}