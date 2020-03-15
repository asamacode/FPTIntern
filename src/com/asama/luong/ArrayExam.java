package com.asama.luong;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExam {

	public static void main(String[] args) {
		
		int n, sum = 0;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Nhap vao n: ");
			n = sc.nextInt();
			
		} while (n < 0);
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			System.out.println("Nhap vao phan tu thu "+ i);
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0 && arr[i] % 2 != 0) {
				sum += arr[i];
			}
		}
		System.out.println("Tong so duong le la: "+ sum);
		
		System.out.println("Nhap vao so k: ");
		int k = sc.nextInt();
		boolean check = false;
		for (int i = 0; i < arr.length; i++) {
			if (k == arr[i]) {
				System.out.println("K nam o vi tri "+ i);
				check = true;
			}
		}
		if (!check) {
			System.out.println("Khong tim thay "+ k +" trong mang");
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("Them phan tu");
		System.out.println("Nhap so can them vao mang: ");
		int num = sc.nextInt();
		insertItem(num, arr);
		
		sc.close();
	}
	
	public static void insertItem(int val,int[] arr){
	      int i;
	      for(i = 0; i < arr.length - 1; i++){
	        if(arr[i] > val) {
	        	break;
	        }
	      }
	      for(int k = arr.length - 2; k >= i; k--){
	        arr[k+1] = arr[k];            
	      }
	      arr[i] = val;
	      System.out.println(Arrays.toString(arr));

	    }
}
