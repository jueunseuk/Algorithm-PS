package Implementation;
import java.io.IOException;
import java.io.InputStream;

public class Main_33897_벽력일섬 {

	public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        
        int n = fr.nextInt();
        
        int []input = new int[n];
        
        int cnt = 0;
        int max = 0;
        int length = 1;
        
        for(int i = 0; i < n; i++) {
        	input[i] = fr.nextInt();
        	
        	if(i > 0) {
        		if(input[i-1] <= input[i]) {
        			length++;
        		} else {
        			max = Math.max(max, length);
        			cnt++;
        			length = 1;
        		}
        	}
        }
        
        max = Math.max(max, length);
		cnt++;
        
        System.out.println(cnt+" "+max);
	}
	
	static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int idx = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (idx >= len) {
                len = in.read(buffer);
                idx = 0;
                if (len == -1) return -1;
            }
            return buffer[idx++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = readByte(); } while (c <= 32 && c != -1);
            if (c == '-') { sign = -1; c = readByte(); }
            while (c > 32 && c != -1) {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }
}