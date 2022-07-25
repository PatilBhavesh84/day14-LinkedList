package com.BridgeLabz;

public class LinkedList {

	Node head;
	Node tail;
	int size;

	class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public LinkedList() {
		this.size = 0;
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	public void addValue(int val) {
		Node node = new Node(val);
		node.next = head;
		head = node;

		if (tail == null) {
			tail = head;
		}
		size += 1;
	}
}
