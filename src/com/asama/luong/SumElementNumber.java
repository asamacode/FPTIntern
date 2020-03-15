package com.asama.luong;

import java.util.Scanner;

public class SumElementNumber {

	static int n;
	static int sum = 0;
	static int mul = 1;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		do {
        	System.out.println("Nhap vao gia tri n = ");
            n = sc.nextInt();
        } while (n < 1);
		
		sc.close();
		
		while (n > 0) {
			int temp = n % 10;
			sum += temp;
			mul *= temp;
			n /= 10;
		}
		
		System.out.println("Tong la: " + sum);
		System.out.println("Tich la: " + mul);
	}

}
