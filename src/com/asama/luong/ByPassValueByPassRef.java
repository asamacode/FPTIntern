package com.asama.luong;

/**
 * @author asamacode
 * Day la JavaDoc
 */

/*Khac nhau giua Comments va JavaDoc
 * Day la comments
 * Comments bat dau bang /* hoac //, dung de mo ta noi dung code, khong duoc bien dich
 * JavaDoc bat dau bang /**, la mot cong cu di voi JDK dung de tao ra Java code documentation
 * */
public class ByPassValueByPassRef {

	public static void main( String[] args ){
	    Dog dog = new Dog("Sun");
	    foo(dog);

	    if (dog.getName().equals("Sun")) {
	        System.out.println( "Java passes by value." );

	    } else if (dog.getName().equals("Bunga")) {
	        System.out.println( "Java passes by reference." );
	    }
	}

	public static void foo(Dog d) {
	    System.out.println("Dog name: Sun -"+d.getName().equals("Sun"));
	    
	    d = new Dog("Bunga");
	    System.out.println("Dog name: Bunga -"+d.getName().equals("Bunga"));
	}
}
class Dog {
	private String name;

	/**
	 * @param name Khoi tao ten
	 */
	public Dog(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return Ten cua chu cun
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name Dat ten
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
