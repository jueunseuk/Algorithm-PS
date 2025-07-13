package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2903_중앙이동알고리즘 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int arr[] = {2, 3, 5, 9, 17, 33, 65, 129, 257, 513, 1025, 2049, 4097, 8193, 16385, 32769};
        
        int n = Integer.parseInt(br.readLine());
        
        System.out.println(arr[n]*arr[n]);
	}

}
