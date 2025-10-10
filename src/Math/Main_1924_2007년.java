package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class Main_1924_2007년 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String month = st.nextToken();
        String day = st.nextToken();
        
        if(month.length() == 1) {
        	month = "0"+month;
        }
        if(day.length() == 1) {
        	day = "0"+day;
        }
        
        LocalDate target = LocalDate.parse(String.valueOf("2007-"+month+"-"+day));
        System.out.println(target.getDayOfWeek().toString().substring(0, 3));
	}
}