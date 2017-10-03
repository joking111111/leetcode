package medium;

import java.util.Arrays;

public class ThreeSumClosest16 {
	public int threeSumClosest(int[] nums, int target) {
		int rst = 0;
		if (nums.length < 3) {
			return 0;
		}

		Arrays.sort(nums);
		rst = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			for (int j = i + 1, k = nums.length - 1; j < k;) {
				int sum = nums[i] + nums[j] + nums[k];
				if (Math.abs(sum - target) < Math.abs(rst - target)) {
					rst = sum;
				}
				if (sum < target) {
					do {
						j++;
					} while (nums[j] == nums[j - 1] && j < k);
				} else if (sum > target) {
					do {
						k--;
					} while (nums[k] == nums[k + 1] && j < k);
				} else {
					return target;
				}
			}
		}

		return rst;
	}
}
