package Z_Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;

public class BitTester {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(Integer.parseInt(br.readLine(), 2));
		
		CRC32 crc = new CRC32();
	    crc.update("hello".getBytes(StandardCharsets.UTF_8));
	    long v = crc.getValue(); // unsigned 32-bit
	    System.out.printf("CRC-32 = 0x%08X%n", v);
	}

}
