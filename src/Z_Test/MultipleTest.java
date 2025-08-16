package Z_Test;

public class MultipleTest {
    static volatile int sink;

    static long benchShift(int iters) {
        int a = 1;
        long t0 = System.nanoTime();
        for (int i = 0; i < iters; i++) {
            a = (a << 1) + 1;
        }
        long dt = System.nanoTime() - t0;
        sink = a;
        return dt;
    }

    static long benchMul(int iters) {
        int a = 1;
        long t0 = System.nanoTime();
        for (int i = 0; i < iters; i++) {
            a = a * 2 + 1;
        }
        long dt = System.nanoTime() - t0;
        sink = a;
        return dt;
    }

    public static void main(String[] args) {
        final int warmup = 5_000_000;
        final int iters  = 50_000_000;

        benchShift(warmup);
        benchMul(warmup);

        long s = benchShift(iters);
        long m = benchMul(iters);

        System.out.println("shift: " + s/1_000_000.0 + " ms");
        System.out.println("mul  : " + m/1_000_000.0 + " ms");
    }
}
