package medium;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters03 {
	public int lengthOfLongestSubstring(String s) {
		int[] dict = new int[256];
		Arrays.fill(dict, -1);
		int max = 0, start = -1;
		for (int i = 0; i < s.length(); i++) {
			if (dict[s.charAt(i)] > start) {
				start = dict[s.charAt(i)];
			}
			dict[s.charAt(i)] = i;
			max = Math.max(max, i - start);
		}

		return max;
	}
}
