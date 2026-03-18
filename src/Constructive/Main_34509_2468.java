package Constructive;

public class Main_34509_2468 {
	public static void main(String[] args) {
        for(int i = 1; i <= 9; i++) {
        	for(int j = 0; j <= 9; j++) {
        		if((j*10+i) % 4 == 0) {
        			if((i + j) % 6 == 0) {
        				if(i != 8 && j != 8) {
        					System.out.println(i*10+j);
        					return;
        				}
        			}
        		}
        	}
        }
	}
}