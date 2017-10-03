package easy;

import java.util.Arrays;

public class ClimbingStairs70 {
	public int climbStairs(int n) {
		return (int) fib(n);
	}

	public long[] power(long[] a, int n) {
		if (n <= 0 || a.length != 4) {
			return null;
		}

		long[] result = new long[] { 1, 0, 0, 1 };
		long[] temp = new long[4];
		while (n > 0) {
			if ((n & 1) == 1) {
				temp[0] = result[0] * a[0] + result[1] * a[2];
				temp[1] = result[0] * a[1] + result[1] * a[3];
				temp[2] = result[2] * a[0] + result[3] * a[2];
				temp[3] = result[2] * a[1] + result[3] * a[3];
				// result = temp;//浅拷贝
				result = Arrays.copyOf(temp, 4);
			}

			n = n >> 1;

			temp[0] = a[0] * a[0] + a[1] * a[2];
			temp[1] = a[0] * a[1] + a[1] * a[3];
			temp[2] = a[2] * a[0] + a[3] * a[2];
			temp[3] = a[2] * a[1] + a[3] * a[3];
			// a = temp;//浅拷贝
			a = Arrays.copyOf(temp, 4);
		}

		return result;
	}

	public long fib(int n) {
		if (n < 0) {
			return -1;
		} else if (n == 0) {
			return 0;
		}

		long[] result = power(new long[] { 0, 1, 1, 1 }, n);
		return result[1];
	}
}
