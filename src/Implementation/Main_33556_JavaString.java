package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_33556_JavaString {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String a = br.readLine();
        String b = br.readLine();
        
        if(a.equals("null")) {
        	System.out.println("NullPointerException");
        	System.out.println("NullPointerException");
        	return;
        } else if(a.equals("Null") && b.equals("null")) {
        	System.out.println("false");
        	System.out.println("false");
        	return;
        }
        
        System.out.println(a.equals(b));
        System.out.println(a.equalsIgnoreCase(b));
	}
}