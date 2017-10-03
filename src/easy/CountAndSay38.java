package easy;

public class CountAndSay38 {
	/**
	 * 用stringbuilder更快
	 * @param n
	 * @return
	 */
	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		if (n == 1) {
			return "1";
		}

		String curStr = "1";
		String newStr = "";
		for (int i = 0; i < n - 1; i++) {
			int cnt = 1;
			for (int j = 1; j < curStr.length(); j++) {
				if (curStr.charAt(j) == curStr.charAt(j - 1)) {
					cnt++;
				} else {
					newStr += cnt;
					newStr += curStr.charAt(j - 1);
					cnt = 1;
				}
			}
			newStr += cnt;
			newStr += curStr.charAt(curStr.length() - 1);
			curStr = newStr;
			newStr = "";
		}
		return curStr;
	}
}
