package com.asama.luong;

import java.util.Scanner;

public class SumFraction {
	
	static int n;
	static float sum = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        do {
        	System.out.println("Nhap vao gia tri n = ");
            n = sc.nextInt();
        } while (n < 1);
		
		for (int i = 1; i <= n; i++) {
			sum += (float) 1/i;
		}
		
		sc.close();
		
		System.out.println("Tong la: " + sum);
	}
}
