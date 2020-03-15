package com.asama.luong;

import java.util.Scanner;

public class ArrayMatrix {

	public static void main(String[] args) {
		
		int m, n;
		int sumMul = 1;
		
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Nhap vao dong m: ");
			m = sc.nextInt();
		} while (m < 0);
		
		do {
			System.out.println("Nhap vao cot n: ");
			n = sc.nextInt();
		} while (n < 0);
		
		int a[][] = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("Nhap vao phan tu a["+ i+ "]" +"["+j+"]");
				a[i][j] = sc.nextInt();
			}
		}
		
		boolean check = false;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] % 3 == 0) {
					sumMul *= a[i][j];
					check = true;
				}
			}
		}
		if (check) {
			System.out.println("Tich boi so 3 cua dong dau tien: "+ sumMul);
		} else {
			System.out.println("Tich boi so 3 cua dong dau tien: "+ 0);
		}
		
		
		int maxArr[] = new int[m];
		int i = 0;
		int max = 0;
		while (i < m) { 
            for (int j = 0; j < a[i].length; j++) { 
                if (a[i][j] > max) { 
                    max = a[i][j]; 
                } 
            } 
            maxArr[i] = max; 
            max =0; 
            i++; 
        } 
		System.out.println("Mang phan tu lon nhat tung dong: ");
		for (int j = 0; j < maxArr.length; j++) {
			System.out.print(maxArr[j] + " ");
		}
		
		sc.close();
		
	}

}
