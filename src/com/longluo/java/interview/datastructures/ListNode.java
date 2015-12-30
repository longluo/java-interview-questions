package com.longluo.java.interview.datastructures;

// Basic node stored in a linked list
// Note that this class is not accessible outside
// of package DataStructures

public class ListNode {
	// Constructors
	public ListNode(Object theElement) {
		this(theElement, null);
	}

	public ListNode(Object theElement, ListNode n) {
		element = theElement;
		next = n;
	}

	// Friendly data; accessible by other package routines
	public Object element;
	public ListNode next;
}
