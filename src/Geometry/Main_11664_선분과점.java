package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11664_선분과점 {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double[] A = new double[3];
        A[0] = Double.parseDouble(st.nextToken());
        A[1] = Double.parseDouble(st.nextToken());
        A[2] = Double.parseDouble(st.nextToken());
        double[] B = new double[3];
        B[0] = Double.parseDouble(st.nextToken());
        B[1] = Double.parseDouble(st.nextToken());
        B[2] = Double.parseDouble(st.nextToken());
        double[] P = new double[3];
        P[0] = Double.parseDouble(st.nextToken());
        P[1] = Double.parseDouble(st.nextToken());
        P[2] = Double.parseDouble(st.nextToken());

        double dist = getSegmentPointDistance(A, B, P);
        System.out.printf("%.10f\n", dist);
    }

    static double getSegmentPointDistance(double[] A, double[] B, double[] P) {
        double[] AB = {B[0] - A[0], B[1] - A[1], B[2] - A[2]};
        double[] AP = {P[0] - A[0], P[1] - A[1], P[2] - A[2]};

        double dotABAB = dot(AB, AB);
        double dotAPAB = dot(AP, AB);

        double t = dotAPAB / dotABAB;

        if (t < 0.0) {
            return distance(A, P);
        } else if (t > 1.0) {
            return distance(B, P);
        } else {
            double[] C = { A[0] + t * AB[0], A[1] + t * AB[1], A[2] + t * AB[2] };
            return distance(C, P);
        }
    }

    static double distance(double[] X, double[] Y) {
        return Math.sqrt((X[0] - Y[0])*(X[0] - Y[0]) + (X[1] - Y[1])*(X[1] - Y[1]) + (X[2] - Y[2])*(X[2] - Y[2]));
    }

    static double dot(double[] A, double[] B) {
        return A[0]*B[0] + A[1]*B[1] + A[2]*B[2];
    }
}