package com.vikram.java.innovations;

public class LinkedListRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(5);
		
		LinkedList l = new LinkedList(n1);
		l.printLinkedList(); // 5
		
		l.insertFirst(new Node(7));
		l.printLinkedList(); // 7 5
		
		l.insertLast(new Node(10));
		l.printLinkedList(); // 7 5 10
		
		l.insertAtIndex(new Node(3), 1);
		l.printLinkedList(); // 7 3 5 10
	
		l.insertAtIndex(new Node(13), 1);
		l.printLinkedList(); // 7 13 3 5 10
		
		l.insertAtIndex(new Node(25), 0);
		l.printLinkedList(); // 25 7 13 3 5 10

	}

}
