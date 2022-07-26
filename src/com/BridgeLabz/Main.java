package com.BridgeLabz;

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFirst(70);
		list.addFirst(30);
		list.addFirst(56);
		list.addLast(40);
		list.displaySize();
		list.sort();
		list.display();
	}
}