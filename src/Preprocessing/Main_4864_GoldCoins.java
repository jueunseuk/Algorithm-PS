package Preprocessing;

public class Main_4864_GoldCoins {
	static final int MAX = 10000;
    static int[] total = new int[MAX + 1];

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
		
		preprocessing();

		StringBuilder sb = new StringBuilder();
		while(true) {
			int input = rd.nextInt();
			if(input == 0) break;
			sb.append(input+" ").append(total[input]+"\n");
		}
		
		System.out.println(sb.toString().trim());
	}

	private static void preprocessing() {
		int day = 1;
        int cpd = 1;

        for (int i = 1; i <= MAX; i++) {
            total[i] = total[i-1] + cpd;
            day++;
            if (day > cpd) {
            	cpd++;
                day = 1;
            }
        }
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
