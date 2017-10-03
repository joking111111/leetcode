package medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93 {
	public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<>();
		if (s.length() > 12) {
			return list;
		}
		int len = s.length();
		for (int i = 0; i < 3 && i <= len - 3; i++) {
			for (int j = i + 1; j < i + 4 && j <= len - 2; j++) {
				for (int k = j + 1; k < j + 4 && k <= len - 1; k++) {
					String s1 = s.substring(0, i + 1);//左闭右开
					String s2 = s.substring(i + 1, j + 1);
					String s3 = s.substring(j + 1, k + 1);
					String s4 = s.substring(k + 1, len);
					if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
						list.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}
		return list;
	}

	public boolean isValid(String num) {
		if (num.length() > 3 || num.length() == 0 || (num.length() > 1 && num.charAt(0) == '0')
				|| Integer.parseInt(num) > 255) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		RestoreIPAddresses93 r = new RestoreIPAddresses93();
		String string = "0000";
		System.out.println(r.restoreIpAddresses(string));
	}
}
