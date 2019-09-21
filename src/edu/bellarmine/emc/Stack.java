package edu.bellarmine.emc;

/**
 * This class implements a stack.
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 1
 * Fall 2019
 */

public class Stack<T> implements StackInterface<T> {
	
	private Node top;//a reference to the head node in the stack
	
	/**
	 * Constructor - creates an empty stack.
	 */
	public Stack() {
		top = null;
	}// end constructor
	
	/**
	 * Adds the passed data to the stack.
	 */
	public void push(T newEntry) {
		
		Node tempNode = new Node(newEntry, top);
		top = tempNode;
		
	}// end "push" method
	
	/**
	 * Returns the top node in the stack, but doesn't remove it.
	 */
	public T peek() {
		
		if (isEmpty()) {return null;}
		
		return top.getData();
	}// end "peek" method
	
	/**
	 * Removes the top node in the stack and returns it.
	 */
	public T pop() {
		
		if (isEmpty()) {return null;}
		
		Node tempNode = top;
		
		top = tempNode.getNextNode();
		
		return tempNode.getData();
	}// end "pop" method
	
	/**
	 * Returns true if the stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		
		if (top == null) {return true;} 
		
		return false;
	}// end "isEmpty" method
	
	/**
	 * Empties the stack.
	 */
	public void clear() {
		top = null;
	}// end "clear" method
	
	/**
	 * This inner class represents the nodes in the stack.
	 * 
	 * @author Ethan Colbert
	 */
	private class Node {
		
		private T data;
		private Node nextNode;
		
		/**
		 * Constructor
		 * @param newData - the data we want in the node
		 * @param nextInChain - the next node in the chain
		 */
		public Node(T newData, Node nextInChain) {
			data = newData;
			nextNode = nextInChain;
		}// end constructor

		/**
		 * @return the data
		 */
		public T getData() {
			return data;
		}

		/**
		 * @param data - the data to set
		 */
		public void setData(T data) {
			this.data = data;
		}

		/**
		 * @return the nextNode
		 */
		public Node getNextNode() {
			return nextNode;
		}

		/**
		 * @param nextNode - the nextNode to set
		 */
		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
		
	}// end "Node" inner class
	
}// end "Stack" class
