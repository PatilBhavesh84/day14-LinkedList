package com.BridgeLabz;

public class LinkedList {

	Node head;
	Node tail;
	int size;

	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
		public Node(int value, Node next) { 
			this.value = value;
			this.next = next;
		}
	}
	public LinkedList() {
		this.size = 0;
	}
	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
	}
	public void addFirst(int val) {
		Node node = new Node(val);

		node.next = head;
		head = node;

		if (tail == null) {
			tail = head;
		}
		size += 1;
	}
	public void addLast(int val) {
		if (tail == null) {
			addFirst(val);
			return;
		}

		Node node = new Node(val);
		tail.next = node;
		tail = node;
		size++;
	}
	public void insertValAtIndex(int val, int index) {
		if (index == 0) {
			addFirst(val);
			return;
		}
		if (index == size) {
			addLast(val);
			return;
		}

		Node temp = head;
		for (int i = 1; i < index; i++) {
			temp = temp.next;
		}

		Node node = new Node(val, temp.next);
		temp.next = node;
		size++;
	}

	public Node get(int index) {
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;

	}
	public int findNode(int value) {
		Node node = head;
		int index=0;
		while (node != null) {
			if (node.value == value) {
				index++;
				System.out.println(value+" Index is "+index);
			}
			node = node.next;
		}
		return index;
	}
	public void insertAfter(int givenValue ,int value) {
		int index = findNode(value);
		insertValAtIndex(givenValue,index+1);  	
	}
	public void displaySize() {
		System.out.println("Size of list is "+size);
	}
}