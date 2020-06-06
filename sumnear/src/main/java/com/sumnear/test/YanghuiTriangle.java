package com.sumnear.test;

/**
 * Ñî»ÔÈı½Ç
 * 
 * @author Near
 *
 */
public class YanghuiTriangle {
	public static void main(String[] args) {
		printYanghui(7);
	}

	private static void printYanghui(int x) {
		int[][] arr = new int[x][];
		for (int i = 0; i < x; i++) {
			arr[i] = new int[i + 1];
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
				}
			}
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
