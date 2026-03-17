package Constructive;

public class Main_Test {

	public static void main(String[] args) {
		for(int i = 1; i <= 50; i++) {
			for(int j = 1; j <= 50; j++ ) {
				if((i+j+1)%50 == 0) System.out.println(i+" "+j);
			}
		}
	}

}
