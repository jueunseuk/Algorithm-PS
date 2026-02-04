package Sweeping;

import java.io.*;
import java.util.*;

public class Main_34987_급식뭐먹지 {
    static class Student {
        int a, b;
        Student(int a, int b) { this.a = a; this.b = b; }
    }

    static class Fenwick {
        int n;
        int[] tree;
        Fenwick(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }
        void add(int idx, int delta) {
            for (; idx <= n; idx += idx & -idx) tree[idx] += delta;
        }
        int sum(int idx) {
            int res = 0;
            for (; idx > 0; idx -= idx & -idx) res += tree[idx];
            return res;
        }
    }

    static int upperBound(int[] arr, int x) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] <= x) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Student[] students = new Student[N];
        int[] bAll = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            students[i] = new Student(a, b);
            bAll[i] = b;
        }

        Arrays.sort(students, Comparator.comparingInt(s -> s.a));

        Arrays.sort(bAll);
        int[] bUniq = Arrays.stream(bAll).distinct().toArray();

        Fenwick fw = new Fenwick(bUniq.length);

        int ans = 0;
        int p = 0;

        for (int x = 0; x <= M; x++) {
            while (p < N && students[p].a <= x) {
                int b = students[p].b;
                int idx = upperBound(bUniq, b);
                fw.add(idx, 1);
                p++;
            }

            int limit = M - x;
            int up = upperBound(bUniq, limit);
            int cnt = fw.sum(up);
            if (cnt > ans) ans = cnt;
        }

        System.out.println(ans);
    }
}
