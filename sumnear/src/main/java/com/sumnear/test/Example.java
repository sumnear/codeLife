package com.sumnear.test;

import java.util.Scanner;

public class Example {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		char[] arr = input.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (char) (arr[i] ^ 20000);
		}
		System.out.println(new String(arr));

	}
}
