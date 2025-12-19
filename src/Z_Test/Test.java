package Z_Test;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) throws Exception {
		Set<int[]> a = new HashSet<>();
		a.add(new int[]{1,2,3});

		Set<int[]> b = new HashSet<>();
		b.add(new int[]{1,2,3});

		Set<Integer> c = new HashSet<>();
		c.add(1);

		Set<Integer> d = new HashSet<>();
		d.add(1);
		
		System.out.println(a.containsAll(b));
		System.out.println(a.contains(new int[] {1,2,3}));
		System.out.println(a.equals(b));
		System.out.println(c.contains(d));
		System.out.println(c.equals(d));

	}

}
