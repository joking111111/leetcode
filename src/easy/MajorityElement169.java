package easy;

public class MajorityElement169 {
	public int majorityElement(int[] nums) {
		int major = 0, count = 0;
		for (int num : nums) {
			if (count != 0) {
				if (major == num) {
					count++;
				} else {
					count--;
				}
			} else {
				major = num;
				count++;
			}

			if (count > nums.length / 2) {
				break;
			}
		}

		return major;
	}
}
