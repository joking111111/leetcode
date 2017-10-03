package medium;

public class SearchforaRange34 {
	public int[] searchRange(int[] nums, int target) {
		int bgn = 0, end = nums.length - 1, mid, left, right;
		while (bgn <= end) {
			mid = (bgn + end) / 2;
			if (nums[mid] >= target) {
				end = mid - 1;
			} else {
				bgn = mid + 1;
			}
		}
		left = bgn;

		end = nums.length - 1;
		while (bgn <= end) {
			mid = (bgn + end) / 2;
			if (nums[mid] > target) {
				end = mid - 1;
			} else {
				bgn = mid + 1;
			}
		}
		right = bgn;

		if (left == right) {
			return new int[] { -1, -1 };
		} else {
			return new int[] { left, right - 1 };
		}
	}
}
