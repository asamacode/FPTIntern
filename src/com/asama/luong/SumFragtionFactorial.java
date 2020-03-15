package com.asama.luong;

import java.util.Scanner;



public class SumFragtionFactorial {
	
	static int n;
	static float sum = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		do {
        	System.out.println("Nhap vao gia tri n = ");
            n = sc.nextInt();
        } while (n < 1);
		
		for (int i = 1; i <= n; i++) {
			sum += (float) 1/factorialCount(2*i - 1);
		}
		
		sc.close();
		
		System.out.println("Tong la: "+ sum);
	}
	
	private static int factorialCount(int num) {
		
		int temp = 1;
		
		if (num == 1) {
			return 1;
		}
		
		for (int i = 2; i <= num; i++) {
			temp *= i;
		}
		
		return temp;
	}
}
