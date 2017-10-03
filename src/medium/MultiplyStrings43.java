package medium;

public class MultiplyStrings43 {
	public String multiply(String num1, String num2) {
		String ret = "";
		int sz1 = num1.length();
		int sz2 = num2.length();
		int[] mul = new int[sz1 + sz2];

		for (int i = 0; i < sz1; i++) {
			if (num1.charAt(sz1 - 1 - i) == '0') {
				continue;
			}
			int carry = 0;
			int n1 = num1.charAt(sz1 - 1 - i) - 48;
			for (int j = 0; j < sz2; j++) {
				int n2 = num2.charAt(sz2 - 1 - j) - 48;
				int sum = n1 * n2 + mul[i + j] + carry;
				carry = sum / 10;
				mul[i + j] = sum % 10;
			}
			mul[i + sz2] += carry;

		}

		for (int i = sz1 + sz2 - 1; i >= 0; i--) {
			if (ret.isEmpty() && mul[i] == 0) {
				continue;
			} else {
				ret += mul[i];
			}
		}

		if (ret.isEmpty()) {
			return "0";
		} else {
			return ret;
		}
	}

	public static void main(String[] args) {
		MultiplyStrings43 m = new MultiplyStrings43();
		System.out.println(m.multiply("1", "1"));
	}
}
