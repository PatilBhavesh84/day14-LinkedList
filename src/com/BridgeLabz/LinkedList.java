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
	public int deleteFirst() {
		int val = head.value;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		size--;
		return val;
	}
	public Node get(int index) {
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	public int deleteLast() {
		if (size <= 1) {
			return deleteFirst();
		}
		Node secondLast = get(size - 2);
		int val = tail.value;
		tail = secondLast;
		tail.next = null;
		size--;
		return val;
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
	public int deleteIndex(int index) {
		if (index == 0) {
			return deleteFirst();
		}
		if (index == size - 1) {
			return deleteLast();
		}

		Node prev = get(index - 1);
		int val = prev.next.value;

		prev.next = prev.next.next;
		size--;
		return val;
	}
	public void displaySize() {
		System.out.println("Size of list is "+size);
	}
	public void sort() {
		sort(size - 1, 0);
	}

	private void sort(int row, int col) {
		if (row == 0) {
			return;
		}

		if (col < row) {
			Node first = get(col);
			Node second = get(col + 1);

			if (first.value > second.value) {
				// swap
				if (first == head) {
					head = second;
					first.next = second.next;
					second.next = first;
				} 
				else if (second == tail) {
					Node prev = get(col - 1);
					prev.next = second;
					tail = first;
					first.next = null;
					second.next = tail;
				} 
				else {
					Node prev = get(col - 1);
					prev.next = second;
					first.next = second.next;
					second.next = first;
				}
			}
			sort(row, col + 1);
		} else {
			sort(row - 1, 0);
		}
	}
}