package com.asama.luong;

import java.lang.reflect.Field;
import java.util.Scanner;

public class ReverseString {
	
	public static void main(String[] args) {
	
		String text = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap vao chuoi: ");
		text = sc.nextLine();
		
		System.out.println("Dao nguoc: " + revertString(text));
		
		System.out.println("Viet hoa: " + toUpperCase(text));
		
		System.out.println("Viet thuong: " + toLowerCase(text));
		
		int[] countArr = new int[Character.MAX_VALUE];
		
		System.out.println("Char" + " " + "Count");
		for (int i = 0; i < text.length(); i++) {
			
			try{
                countArr[(int)text.charAt(i)]++;
            }catch(StringIndexOutOfBoundsException e){
                System.out.println("Loi");
            }
        }
        for(int i=0;i<countArr.length;i++){
            
            if(countArr[i]!=0){
                System.out.println((char)i + "      " + countArr[i]);
            }
		}
        
        System.out.println("Nhap n: ");
        int n = sc.nextInt();
        System.out.println("Nhap m: ");
        int m = sc.nextInt();
        
        sc.close();
        
        System.out.println("Cat chuoi tu vi tri " + n + " den " +m+ ": " + substring(text, n,m));
	}
	
	public static String toUpperCase(String s){
	    String str = "";
	    for(int x = 0; x < s.length(); x++){
	        char ch = s.charAt(x);
	        if(ch >= 'a' && ch <= 'z')
	            str += "" + (char)(ch - 32);
	        else
	            str += "" + ch; 
	    }
	    return str;
	}
	
	public static String toLowerCase(String s){
	    String str = "";
	    for(int x = 0; x < s.length(); x++){
	        char ch = s.charAt(x);
	        if(ch <= 'Z' && ch >= 'A')
	            str += "" + (char)(ch + 32);
	        else
	            str += "" + ch; 
	    }
	    return str;
	}
	
	public static String revertString(String str) {
		
		byte [] strAsByteArray = str.getBytes(); 
		  
        byte [] result = new byte [strAsByteArray.length]; 
  
        for (int i = 0; i<strAsByteArray.length; i++) 
            result[i] =  
             strAsByteArray[strAsByteArray.length-i-1]; 
        
        return new String(result);
		
	}
	
	public static String substring(String s, int from, int to){
        Field f;
        char[] arr = null;
		try {
			f = String.class.getDeclaredField("value");
			f.setAccessible(true);
	        arr = (char[])f.get(s);
	        f.setAccessible(false);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new String(arr, from, to - from);
	}
	
}
