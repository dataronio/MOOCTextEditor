package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode<E>();
		tail = new LLNode<E>();
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if (element == null) {
			throw new NullPointerException("You tried to add a null element.");
		}
		LLNode<E> tempNode = new LLNode<E>(element);
		LLNode<E> endNode = this.head;
		while (endNode.next != this.tail) {
			endNode = endNode.next;
		}
		endNode.next = tempNode;
		tail.prev = tempNode;
		tempNode.next = this.tail;
		tempNode.prev = endNode;
		(this.size)++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Your index is out of bounds.");
		}
		LLNode<E> curr = this.head;
		for (int i = 0;i <= index; i++) {
			curr = curr.next;
		}
		return curr.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Your index is out of bounds.");
		}
		if (element == null) {
			throw new NullPointerException("You tried to add a null element.");
		}
		LLNode<E> curr = this.head;
		for (int i = 0;i <= index; i++) {
			curr = curr.next;
		}
		LLNode<E> prevNode = curr.prev;
		LLNode<E> tempNode = new LLNode<E>(element, prevNode, curr);
		curr.prev = tempNode;
		prevNode.next = tempNode;
		this.size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Your index is out of bounds.");
		}
		LLNode<E> curr = this.head;
		for (int i = 0;i <= index; i++) {
			curr = curr.next;
		}
		LLNode<E> prevNode = curr.prev;
		LLNode<E> nextNode = curr.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		this.size--;
		return curr.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Your index is out of bounds.");
		}
		if (element == null) {
			throw new NullPointerException("You tried to add a null element.");
		}
		LLNode<E> curr = this.head;
		for (int i = 0;i <= index; i++) {
			curr = curr.next;
		}
		E dat = curr.data;
		curr.data = element;
		return dat;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	public LLNode()
	{
	   this.data = null;
	   this.prev = null;
	   this.next = null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prevNode)
	{
		this.data = e;
		this.prev = prevNode;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prevNode, LLNode<E> nextNode)
	{
		this.data = e;
		this.prev = prevNode;
		this.next = nextNode;
	}

}
