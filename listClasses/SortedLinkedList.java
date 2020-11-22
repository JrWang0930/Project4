package listClasses;

import java.util.*;

public class SortedLinkedList<T> extends BasicLinkedList<T> {

	private Comparator<T> comparator;

	public SortedLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	public SortedLinkedList<T> add(T element) {
		Node curr = head;
		Node prev = null;
		Node newNode = new Node(element);
		if (size == 0) {
			super.addToFront(element);
		} else {
			while (curr != null) {
				int result = comparator.compare(element, curr.data);
				if (result <= 0) {
					size++;
					if (prev == null) {
						head = newNode;
						head.next = curr;
					} else {
						prev.next = newNode;
						newNode.next = curr;
					}
					break;
				}
				prev = curr;
				curr = curr.next;
			}
			if (curr == null) {
				size++;
				prev.next = newNode;
				tail = newNode;
			}
		}
		return this;
	}

	public SortedLinkedList<T> remove(T targetData) {
		return (SortedLinkedList<T>) super.remove(targetData, comparator);
	}

	@Override
	public BasicLinkedList<T> addToEnd(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}

	@Override
	public BasicLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}

}