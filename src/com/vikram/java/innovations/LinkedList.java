package com.vikram.java.innovations;

public class LinkedList {
	
	private Node root;
	private int size;
	
	public LinkedList () {
		this.root = null;
		size = 0;
	}
	
	public LinkedList (Node node) {
		this.root = node;
		size = 1;
	}
	
	public void insertFirst (Node node) {
		if (isEmpty()) {
			root = node;
		} else {
			node.setNext(root);
			root = node;
		}
		
		size++;
	}
	
	public void insertLast (Node node) {
		if (isEmpty()) {
			root = node;
		} else {
			Node curr = root;
			
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
			
			curr.setNext(node);
		}
		
		size++;
	}
	
	public void insertAtIndex (Node node, int index) {
		if (index < 0) {
			System.out.println("Please enter the index as a non-negative integer.");
		} else {
			// It is very important to handle this isEmpty() condition separately (otherwise you may need to 
			// handle it again after while loop)
			if (isEmpty()) {
				root = node;
			} else {
				int currIndex = 0;
				Node curr = root;
				
				while (curr.getNext() != null && currIndex < index-1) {
					curr = curr.getNext();
					currIndex++;
				}
				
				if(curr.getNext() == null) { //The nodes already in the LL were less than the index;
											//hence inserting at last position
					curr.setNext(node);
				} else if (currIndex == index-1){
					node.setNext(curr.getNext());
					curr.setNext(node);
				} else if (index == 0) { // This condition was not covered earlier
					node.setNext(root);
					root = node;
				}
			}
			
			size++;
		}		
		
	}
	
	
	public void removeFirst () {
		if (!isEmpty())
			root = root.getNext();
		size--;
	}
	
	public void removeLast () {		
		if (!isEmpty()) {
			Node curr = root;
			Node prev = curr;
			
			if(size == 1) {
				root = null;
			} else {
				while(curr.getNext() != null) {
					prev = curr;
					curr = curr.getNext();
				}
				prev.setNext(null); // Making the second last node as last
			}
			
			size--;
		}
	}
	
	public Node removeAtIndex (int index) {
		if (index < 0) {
			System.out.println("Please enter the index as a non-negative integer.");
			return null;
		} else {
			if (isEmpty() || size < index) {
				return null;
			} else {
				int currIndex = 0;
				Node curr = root;
				Node nodeToBeRemoved;
				
				while (currIndex < index-1) {
					curr = curr.getNext();
					currIndex++;
				}
				
				if (currIndex == index-1){
					nodeToBeRemoved = curr.getNext();
					curr.setNext(nodeToBeRemoved.getNext());
					nodeToBeRemoved.setNext(null);
					size--;
					
					return nodeToBeRemoved;
				} else {
					return null;
				}
			}
			
			
		}		
		
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public void printLinkedList () {
		System.out.println("Linked list is:");
		
		Node curr = root;
		while (curr!=null) {
			System.out.print(curr.getData() +" ");
			curr = curr.getNext();
		}
		System.out.println();
	}
	
}
