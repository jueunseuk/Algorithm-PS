package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9805_Pyramids {

	public static double deter(double[][] matrix) {
	    int n = matrix.length;
	    
	    if(n == 1) {
	        return matrix[0][0];
	    }
	    
	    double det = 0;
	    for (int col = 0; col < n; col++) {
	        double[][] subMatrix = new double[n - 1][n - 1];
	        for (int i = 1; i < n; i++) {
	            int subCol = 0;
	            for (int j = 0; j < n; j++) {
	                if (j == col) continue;
	                subMatrix[i - 1][subCol++] = matrix[i][j];
	            }
	        }
	        det += Math.pow(-1, col) * matrix[0][col] * deter(subMatrix);
	    }
	    return det;
	}

    public static double volume(double a, double b, double c, double d, double e, double f) {
        double[][] matrix = {
            {0,     1,     1,     1,     1},
            {1,     0, a * a, b * b, c * c},
            {1, a * a,     0, d * d, e * e},
            {1, b * b, d * d,     0, f * f},
            {1, c * c, e * e, f * f,     0}
        };

        double determinant = deter(matrix);

        return Math.sqrt((determinant) / 288.0);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());
        double d = Double.parseDouble(st.nextToken());
        double e = Double.parseDouble(st.nextToken());
        double f = Double.parseDouble(st.nextToken());

        double volume = volume(a, b, c, d, e, f);
        
        System.out.println(Math.ceil(volume*10000) / 10000.0);
    }
}
