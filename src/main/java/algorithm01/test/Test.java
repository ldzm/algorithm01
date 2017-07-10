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

	}
}

class A {
	public final static int A_NUM = 10;
	
	final void play() {
		System.out.println("final play();");
	}
}

class B extends A {
	public final static int A_NUM = 10;
}