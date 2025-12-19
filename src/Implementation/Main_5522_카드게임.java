package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5522_카드게임 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int j = 0;
        for(int i = 0; i < 5; i++)
        {
        	j += Integer.parseInt(br.readLine());
        }
        
        System.out.println(j);
	}
}