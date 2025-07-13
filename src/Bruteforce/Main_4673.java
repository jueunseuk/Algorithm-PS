package Bruteforce;

public class Main_4673 {
	
	static boolean[] isSelfNum = new boolean[10001]; // 10000까지 사용가능
	static int sum, number;
	
	public static void main(String[] args) {
		
		for(int i = 1; i <= 10000; i++)
        makeCons(i);
        
        for(int i = 1; i <= 10000; i++) {
        	if(!isSelfNum[i]) System.out.println(i);
        }
	}
	
	public static void makeCons(int n) {
		int sum = n;
        while(n != 0) {
            sum += n % 10;
            n /= 10;
        }
        
        if (sum <= 10000) {
            isSelfNum[sum] = true;
        }
	}
	
}
