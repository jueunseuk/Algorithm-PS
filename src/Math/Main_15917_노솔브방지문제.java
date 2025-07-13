package Math;
import java.util.HashSet;
import java.util.Set;

public class Main_15917_노솔브방지문제 {

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
		
		int n = rd.nextInt();
		
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < 31; i++) {
			set.add(1 << i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(set.contains(rd.nextInt()) ? "1\n" : "0\n");
		}
		
		System.out.println(sb.toString().trim());
	}
	
	static class Reader {
	    private final int SIZE = 1 << 13;
	    private byte[] buffer = new byte[SIZE];
	    private int index, size;
	    
	    int nextInt() throws Exception {
	        int lis = 0;
	        byte c;
	        boolean isMinus = false;
	        while ((c = read()) <= 32);
	        if (c == 45) { c = read(); isMinus = true; }
	        do lis = (lis << 3) + (lis << 1) + (c & 15);
	        while (isnumber(c = read()));
	        return isMinus ? ~lis + 1 : lis;
	    }

	    private boolean isnumber(byte c) {
	        return 47 < c && c < 58;
	    }

	    private byte read() throws Exception {
	        if (index == size) {
	            size = System.in.read(buffer, index = 0, SIZE);
	            if (size < 0) buffer[0] = -1;
	        }
	        return buffer[index++];
	    }
	}
}
