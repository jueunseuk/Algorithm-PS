package Sort;
public class Main_2693_N번째큰수2 {

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
		
		int T = rd.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int n1 = 0, n2 = 0, n3 = 0;
			
			int input;
			for(int i = 0; i < 10; i++) {
				input = rd.nextInt();
				if(input > n1) {
					n3 = n2;
					n2 = n1;
					n1 = input;
				} else {
					if(input > n2) {
						n3 = n2;
						n2 = input;
					} else {
						if(input > n3) {
							n3 = input;
						}
					}
				}
			}
			
			sb.append(n3+"\n");
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