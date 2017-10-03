package medium;

public class ColorSort75 {
	public static void sort(int[] r) {
		int current = 0;
		int begin = 0;
		int end = r.length - 1;
		if (end <= 0) {
			return;
		}
		while (current <= end) {
			if (r[current] == 0) {
				int temp = r[current];
				r[current] = r[begin];
				r[begin] = temp;
				current++;// begin指向的是第一个1的位置，故可以省去一轮判断
				begin++;
			} else if (r[current] == 1) {
				current++;
			} else {
				int temp = r[current];
				r[current] = r[end];
				r[end] = temp;
				end--;
			}
		}
	}
}
