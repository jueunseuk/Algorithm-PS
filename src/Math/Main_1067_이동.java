package Math;

import java.io.*;

public class Main_1067_이동 {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do c = readByte(); while (c <= ' ' && c != -1);
            int sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    static void fft(double[] re, double[] im, boolean invert) {
        int n = re.length;

        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >> 1;
            for (; (j & bit) != 0; bit >>= 1) j ^= bit;
            j ^= bit;

            if (i < j) {
                double tr = re[i]; re[i] = re[j]; re[j] = tr;
                double ti = im[i]; im[i] = im[j]; im[j] = ti;
            }
        }

        for (int len = 2; len <= n; len <<= 1) {
            double ang = 2 * Math.PI / len * (invert ? -1 : 1);
            double wlenRe = Math.cos(ang);
            double wlenIm = Math.sin(ang);

            for (int i = 0; i < n; i += len) {
                double wRe = 1.0, wIm = 0.0;
                int half = len >> 1;

                for (int j = 0; j < half; j++) {
                    int u = i + j;
                    int v = i + j + half;

                    double vRe = re[v] * wRe - im[v] * wIm;
                    double vIm = re[v] * wIm + im[v] * wRe;

                    double uRe = re[u];
                    double uIm = im[u];

                    re[u] = uRe + vRe;
                    im[u] = uIm + vIm;
                    re[v] = uRe - vRe;
                    im[v] = uIm - vIm;

                    double nextWRe = wRe * wlenRe - wIm * wlenIm;
                    double nextWIm = wRe * wlenIm + wIm * wlenRe;
                    wRe = nextWRe;
                    wIm = nextWIm;
                }
            }
        }

        if (invert) {
            for (int i = 0; i < n; i++) {
                re[i] /= n;
                im[i] /= n;
            }
        }
    }

    static long convolutionMaxDot(int[] x, int[] y) {
        int n = x.length;

        int aLen = 2 * n;
        int bLen = n;
        int need = aLen + bLen - 1; // 3N-1

        int m = 1;
        while (m < need) m <<= 1;

        double[] ar = new double[m];
        double[] ai = new double[m];
        double[] br = new double[m];
        double[] bi = new double[m];

        // A = X || X
        for (int i = 0; i < n; i++) {
            ar[i] = x[i];
            ar[i + n] = x[i];
        }

        // B = reverse(Y)
        for (int i = 0; i < n; i++) {
            br[i] = y[n - 1 - i];
        }

        fft(ar, ai, false);
        fft(br, bi, false);

        // pointwise multiply: (a * b)
        for (int i = 0; i < m; i++) {
            double rr = ar[i] * br[i] - ai[i] * bi[i];
            double ii = ar[i] * bi[i] + ai[i] * br[i];
            ar[i] = rr;
            ai[i] = ii;
        }

        fft(ar, ai, true); // inverse FFT

        long ans = Long.MIN_VALUE;
        // indices (N-1) .. (N-1)+(N-1) == 2N-2
        int start = n - 1;
        int end = 2 * n - 2;
        for (int idx = start; idx <= end; idx++) {
            long val = Math.round(ar[idx]); // rounding for floating error
            if (val > ans) ans = val;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) x[i] = fs.nextInt();
        for (int i = 0; i < n; i++) y[i] = fs.nextInt();

        long ans = convolutionMaxDot(x, y);
        System.out.print(ans);
    }
}
