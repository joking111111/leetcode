package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		if (nums.length < 3) {
			return ret;
		}

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			for (int j = i + 1, k = nums.length - 1; j < k;) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < 0) {
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					ret.add(list);

					do {
						j++;
					} while (nums[j] == nums[j - 1] && j < k);

					do {
						k--;
					} while (nums[k] == nums[k + 1] && j < k);
				}
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		ThreeSum15 threeSum = new ThreeSum15();
		System.out.println(threeSum.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}
}
