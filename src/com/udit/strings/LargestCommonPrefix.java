package com.udit.strings;

public class LargestCommonPrefix {

	public static void main(String[] args) {

		String[] strs = { "aca", "cba" };
		LargestCommonPrefix obj = new LargestCommonPrefix();
		System.out.println(obj.longestCommonPrefix(strs));
	}

	public String longestCommonPrefix(String[] strs) {

		if (strs == null || strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		
		String minStr = strs[0];

		for (String str : strs) {
			if (str.length() < minStr.length()) {
				minStr = str;
			}
		}

		StringBuffer sb = new StringBuffer();

		for (String str : strs) {
			sb.setLength(0);
			for (int i = 0; i < str.length(); i++) {
				sb.append(str.charAt(i));
				if (!minStr.startsWith(sb.toString())) {
					sb.deleteCharAt(sb.length() - 1);
					if (sb.length() < minStr.length()) {
						minStr = sb.toString();
					}
					break;
				}
			}
		}
		return minStr;
	}
}
