package com.sumnear.test;

public class YearS { // 1988 1989 1990 1991 1992 1993 1994 1995
	private static final String[] YEAR = { "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪" };

	public static void main(String[] args) {
		for (int i = 1900; i < 2100; i++) {
			System.out.println(i + "年是:" + getSX(i) + "年");
		}
		// System.out.println((1972 - 1984) % 12);
		// for (int i = 1983; i > 1969; i--) {
		// System.out.println(i + "年是:" + getSX(i) + "年");
		// }
	}

	private static String getSX(int years) {
		int y = 1989 - 5; // 鼠年
		if (years > y) {
			return YEAR[(years - y) % 12];
		} else {
			if ((years - y) % 12 == 0)
				return YEAR[(years - y) % 12];
			return YEAR[(years - y) % 12 + 12];
		}

	}

}
