package Graph;

public class Main_Test {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < 100; i++) {
        	sb.append(0);
        	if(i < 99) sb.append(" ");
        }
        sb.append("\n");
        
        for(int i = 0; i < 100; i++) {
        	for(int j = 0 ; j < 100; j++) {
        		if(j == 0 || j == 99) sb.append(0);
        		else sb.append(1);
        		
        		if(j < 99) sb.append(" ");
        	}
        	sb.append("\n");
        }
        
        for(int i = 0 ; i < 100; i++) {
        	sb.append(0);
        	if(i < 99) sb.append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }
}