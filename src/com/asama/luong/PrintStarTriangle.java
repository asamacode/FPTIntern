package com.asama.luong;

import java.util.Scanner;

public class PrintStarTriangle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao gia tri n = ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++) {
            	System.out.print("*");
            }
            System.out.println("");
        }
         
        sc.close();
	}

}
