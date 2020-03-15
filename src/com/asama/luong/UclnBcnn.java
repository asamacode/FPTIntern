package com.asama.luong;

import java.util.Scanner;

public class UclnBcnn {
	
	public static void main(String[] args) {
		
		int num1, num2;
		
		Scanner sc = new Scanner(System.in);
        
        do {
        	System.out.println("Nhap vao so 1: ");
            num1 = sc.nextInt();
            System.out.println("Nhap vao so 2: ");
            num2 = sc.nextInt();
		} while ((num1 <= 0) || (num2 <= 0));
        
        System.out.println("Uoc chung lon nhat: "+ UCLN(num1, num2));
        System.out.println("Boi chung nho nhat: "+ (num1 * num2)/UCLN(num1, num2));

        sc.close();
	}
	
	public static int UCLN(int a, int b) {
		
		while (a != b) {
			if (a > b) {
				a -= b;
			} else {
				b -= a;
			}
		}
		
		return a;	
	}

}
