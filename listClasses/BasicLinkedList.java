package listClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class BasicLinkedList<T> implements Iterable<T> {

	protected int size;
	protected Node head;
	protected Node tail;

	public class Node {
		protected Node next;
		protected T data;

		public Node(T data) {
			this.data = data;
		}
	}

	public BasicLinkedList() {
		size = 0;
	}

	public int getSize() {
		return size;

	}

	public BasicLinkedList<T> addToEnd(T data) {
		Node newEnd = new Node(data);
		size++;
		if (size == 1) {
			this.head = newEnd;
		} else {
			this.tail.next = newEnd;
		}
		this.tail = newEnd;
		return this;
	}

	public BasicLinkedList<T> addToFront(T data) {
		Node newHead = new Node(data);
		newHead.next = this.head;
		this.head = newHead;
		size++;
		if (size == 1) {
			this.tail = newHead;
		}
		return this;
	}

	public T getFirst() {
		if (size == 0) {
			return null;
		}
		return head.data;
	}

	public T getLast() {
		if (size == 0) {
			return null;
		}
		return tail.data;
	}

	public T retrieveFirstElement() {
		if (size == 0) {
			return null;
		}
		size--;
		T output = this.head.data;
		this.head = this.head.next;
		if (size == 0) {
			this.tail = null;
		}
		return output;
	}

	public T retrieveLastElement() {
		if (size == 0) {
			return null;
		}
		size--;
		T output = this.tail.data;
		if (size == 0) {
			this.head = null;
			this.tail = null;
		} else {
			Node curr = this.head;
			while (curr.next != this.tail) {
				curr = curr.next;
			}
			curr.next = null;
			this.tail = curr;
		}
		return output;
	}

	public BasicLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			int result = comparator.compare(curr.data, targetData);
			if (result == 0) {
				if (curr == head) {
					head = curr.next;
				}
				size--;
				if (prev != null) {
					prev.next = curr.next;
				}
			} else {
				prev = curr;
			}
			curr = curr.next;
		}
		tail = prev;
		return this;

	}

	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node curr = head;
			private Node prev = null;

			@Override
			public boolean hasNext() {
				return curr != null;
			}

			@Override
			public T next() {
				prev = curr;
				T output = curr.data;
				curr = curr.next;
				return output;
			}

			public void remove() {
//				size--;
//				if (prev != null) {
//					prev.next = curr;
//				}
//				curr = curr.next;

				throw new UnsupportedOperationException();
			}

		};
	}

	public ArrayList<T> getReverseArrayList() {
		ArrayList<T> arr = new ArrayList<>();
		return reverseArrayListHelper(arr, head);
	}

	private ArrayList<T> reverseArrayListHelper(ArrayList<T> arr, Node node) {
		if (node == null) {
			return arr;
		}
		arr.add(0, node.data);
		return this.reverseArrayListHelper(arr, node.next);
	}

	public BasicLinkedList<T> getReverseList() {
		BasicLinkedList<T> newList = new BasicLinkedList<T>();
		return reverseListHelper(newList, head);
	}

	private BasicLinkedList<T> reverseListHelper(BasicLinkedList<T> list, Node node) {
		if (node == null) {
			return list;
		}
		list.addToFront(node.data);
		return reverseListHelper(list, node.next);
	}

}