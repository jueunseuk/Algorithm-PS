package Math.Prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4134_다음소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            long prime = Long.parseLong(br.readLine());

            if(prime <= 1) {
            	sb.append(2).append("\n");
                continue;
            }

            while(true) {
                long cnt = 0;
                for(long j = 2; j <= Math.sqrt(prime); j++) {
                    if(prime % j == 0) {
                        cnt++;
                        break;
                    }
                }

                if(cnt == 0) {
                	sb.append(prime).append("\n");
                    break;
                }
                prime++;
            }
        }

        System.out.println(sb.toString().trim());
    }
}