package GameTheory;
public class Main_24678_돌무더기게임1 {

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
		
		int T = rd.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int a = rd.nextInt() % 2;
			int b = rd.nextInt() % 2;
			int c = rd.nextInt() % 2;
			
			int cnt = 0;
			
			if(a == 0) cnt++;
			if(b == 0) cnt++;
			if(c == 0) cnt++;
			
			if(cnt >= 2) {
				sb.append("R\n");
			} else {
				sb.append("B\n");
			}
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
