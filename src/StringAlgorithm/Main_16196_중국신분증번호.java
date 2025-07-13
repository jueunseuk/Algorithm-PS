package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_16196_중국신분증번호 {
	static String START = "19000101";
	static String END = "20111231";
	static final int MOD = 11;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int[] each = new int[17];
		int[] concat = new int[4];
		
		for(int i = 0; i < 17; i++) {
			each[i] = input.charAt(i) - '0';
		}
		
		concat[0] = Integer.parseInt(input.substring(0, 6));
		concat[1] = Integer.parseInt(input.substring(6, 14));
		concat[2] = Integer.parseInt(input.substring(14, 17));
		
		int n = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < n; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		
		// filter
		if(!set.contains(concat[0])) {
			System.out.println("I");
			return;
		}
		
		if(concat[2] == 0) {
			System.out.println("I");
			return;
		}
		
		if (!isValidDate(concat[1])) {
            System.out.println("I");
            return;
        }
		
		long sum = 0;
		for(int i = 0, j = 17; i < 17 && j >= 1 ; i++, j--) {
			sum += each[i] << j;
			sum %= MOD;
		}
		
		if(input.charAt(17) == 'X') {
			concat[3] = 10;
		} else {
			concat[3] = input.charAt(17) - '0';
		}
		
		sum += concat[3];
		sum %= MOD;
		
		if(sum != 1) {
			System.out.println("I");
			return;
		}
		
		// result
		if(concat[2] % 2 == 0) {
			System.out.println("F");
		} else {
			System.out.println("M");
		}
		
	}
	
	private static boolean isValidDate(int date) {
        int year = date / 10000;
        int month = (date % 10000) / 100;
        int day = date % 100;

        if (year < 1900 || year > 2011) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }

        int[] maxDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) {
        	maxDay[2] = 29;
        }

        if (day < 1 || day > maxDay[month]) {
            return false;
        }

        return true;
    }
	
	private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
