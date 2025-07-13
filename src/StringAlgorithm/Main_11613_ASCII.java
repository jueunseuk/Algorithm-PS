package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11613_ASCII {
	static String[][] number = {
			{
				"xxxxx",
				"x...x",
				"x...x",
				"x...x",
				"x...x",
				"x...x",
				"xxxxx"
			},
			{
				"....x",
				"....x",
				"....x",
				"....x",
				"....x",
				"....x",
				"....x"
			},
			{
				"xxxxx",
				"....x",
				"....x",
				"xxxxx",
				"x....",
				"x....",
				"xxxxx"
			},
			{
				"xxxxx",
				"....x",
				"....x",
				"xxxxx",
				"....x",
				"....x",
				"xxxxx"
			},
			{
				"x...x",
				"x...x",
				"x...x",
				"xxxxx",
				"....x",
				"....x",
				"....x"
			},
			{
				"xxxxx",
				"x....",
				"x....",
				"xxxxx",
				"....x",
				"....x",
				"xxxxx"
			},
			{
				"xxxxx",
				"x....",
				"x....",
				"xxxxx",
				"x...x",
				"x...x",
				"xxxxx"
			},
			{
				"xxxxx",
				"....x",
				"....x",
				"....x",
				"....x",
				"....x",
				"....x"
			},
			{
				"xxxxx",
				"x...x",
				"x...x",
				"xxxxx",
				"x...x",
				"x...x",
				"xxxxx"
			},
			{
				"xxxxx",
				"x...x",
				"x...x",
				"xxxxx",
				"....x",
				"....x",
				"xxxxx"
			},
			{
				".....",
				"..x..",
				"..x..",
				"xxxxx",
				"..x..",
				"..x..",
				"....."
			},
	};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] input = new char[7][];
        
        for(int i = 0; i < 7; i++) {
        	input[i] = br.readLine().toCharArray();
        }
        
        int maxL = input[0].length;
        
        StringBuilder statement = new StringBuilder();
        
        for(int startCol = 0; startCol < maxL; startCol += 6) {
            boolean found = false;
            
            for(int digit = 0; digit < number.length; digit++) {
                boolean match = true;
                
                for(int row = 0; row < 7 && match; row++) {
                    for(int col = 0; col < 5 && match; col++) {
                        if(input[row][startCol + col] != number[digit][row].charAt(col)) {
                            match = false;
                        }
                    }
                }
                
                if(match) {
                    if(digit < 10) {
                        statement.append(digit);
                    } else {
                        statement.append("+");
                    }
                    found = true;
                    break;
                }
            }
        }
        
        String[] div = statement.toString().split("\\+");
        
        int first = Integer.parseInt(div[0]);
        int second = Integer.parseInt(div[1]);
        
        char[] result = String.valueOf(first+second).toCharArray();
        
        StringBuilder[] answer = new StringBuilder[7];
        
        for(int i = 0; i < 7; i++) {
        	answer[i] = new StringBuilder();
        }
        
        for(char out : result) {
        	for(int i = 0; i < 7; i++) {
        		answer[i].append(number[out - '0'][i]).append(".");
        	}
        }
        
        for(int i = 0; i < 7; i++) {
        	answer[i].deleteCharAt(result.length*6-1);
        	System.out.println(answer[i].toString().trim());
        }
        
	}

}
