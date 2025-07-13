package Recursion;
public class Main_1003_피보나치함수_재귀 {
    public static void main(String[] args) throws Exception {
        long sum = 0;
        
    	for(int i = 0; i < 10; i++) {
	        long start = System.nanoTime();
	        fibo(40);
	        long end = System.nanoTime();
	        sum += (end-start)/1000000;
    	}
    	
    	System.out.println(sum/10+"ms");
    }

	private static int fibo(int n) {
		if(n < 1) {
			return 0;
		} else if(n <= 2) {
			return 1;
		}
		return fibo(n-1)+fibo(n-2);
	}
}
