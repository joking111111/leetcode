package medium;

public class LargestNumber179 {
	public String largestNumber(int[] nums) {
		if (nums.length == 0) {
			return "";
		}
		sort(nums, 0, nums.length - 1);
		if (nums[0] == 0) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		for (int n : nums) {
			sb.append(n);
		}

		return sb.toString();
	}

	/**
	 * 比较函数的作用是确定数字在最终字符串中的排列顺序，
	 * 比较两个数字时，只有两种排序，组成数字大的情况确定两数字最终的排列顺序。
	 * 排序后去掉最后一个原素，剩下的还是按最大的排列。
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static boolean compare(int num1, int num2) {
		String n1 = String.valueOf(num1);
		String n2 = String.valueOf(num2);
		String s1 = n1 + n2;
		String s2 = n2 + n1;
		return s1.compareTo(s2) >= 0 ? true : false;
	}

	public static void sort(int[] a, int i, int j) {
		if (i < j) {
			int pivotloc = partion(a, i, j);
			sort(a, i, pivotloc - 1);
			sort(a, pivotloc + 1, j);
		}
	}

	private static int partion(int[] a, int first, int end) {
		int i = first, j = end, pivot = a[i];
		while (i < j) {
			while ((i < j) && compare(pivot, a[j])) {
				j--;
			}
			a[i] = a[j];
			while ((i < j) && compare(a[i], pivot)) {
				i++;
			}
			a[j] = a[i];
		}

		a[i] = pivot;
		return i;
	}
	
	public static void main(String[] args) {
		LargestNumber179 l = new LargestNumber179();
		int[] a= {1,2};
		System.out.println(l.largestNumber(a));
	}
}
