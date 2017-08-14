package algorithm01.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		//list.add(null);
		//list.remove(0);
		//list.set(0, 1);
		
		//list.add(1, 1);
		//System.out.println(A.A_NUM);
		//Stack s = new Stack();
		
		A a = new B();
		a.play();

		// final 方法可以被继承，不可以被覆盖
		B b = new B();
		b.play();
	}
}

class A {
	
	private int a;
	public int b;
	public final static int A_NUM = 10;
	
	final void play() {
		System.out.println("final play();");
	}
	
	private final void run() {
		System.out.println("A run");
	}
}

class B extends A {
	private int a;
	public int b;
	
	public final static int A_NUM = 10;
	
	private final void run() {
		System.out.println("B run");
	}
	
	public static void main(String[] args) {
		new  B().run();
		
		new B().b = 1;
		
		System.out.println(true|true);
	}
}