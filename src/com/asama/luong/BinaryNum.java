package com.asama.luong;

import java.util.Scanner;

public class BinaryNum {

	public static void main(String[] args) {
		
		int num;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhap vao so nguyen n: ");
		num = sc.nextInt();
		
		System.out.print(num + " sang he nhi phan : ");
		
		while (num > 0) {
			int temp = num % 2;
			num /= 2;
			System.out.print(""+ temp);
		}
		
		sc.close();

	}

}
