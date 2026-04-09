package Constructive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_35430_직사각형색칠하기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long row = Long.parseLong(st.nextToken());
		long col = Long.parseLong(st.nextToken());
		long area = Long.parseLong(st.nextToken());
		
		for(long i = 1; i * i <= area; i++) {
		    if(area % i == 0) {
		        long a = i;
		        long b = area / i;
		        
		        if((a <= row && b <= col) || (a <= col && b <= row)) {
		            System.out.println(1);
		            if(a <= row && b <= col) {
		                System.out.println("0 0 " + a + " " + b);
		            } else {
		                System.out.println("0 0 " + b + " " + a);
		            }
		            return;
		        }
		    }
		}
		
		StringBuilder sb = new StringBuilder();
		if(row > col) {
			if(area <= row) {
				sb.append(1).append("\n");
				sb.append("0 0 ").append(area).append(" "+1);
			} else {
				sb.append(2).append("\n");
				sb.append("0 0 ").append(row).append(" "+area/row).append("\n");
				sb.append("0 ").append(area/row).append(" ").append(area%row).append(" ").append(area/row+1);
			}
		} else {
			if(area <= col) {
				sb.append(1).append("\n");
				sb.append("0 0 1 ").append(area);
			} else {
				sb.append(2).append("\n");
				sb.append("0 0 ").append(area/col+" ").append(col).append("\n");
				sb.append(area/col).append(" 0 ").append(area/col+1).append(" ").append(area%col);
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}