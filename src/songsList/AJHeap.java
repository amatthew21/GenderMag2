package songsList;

import java.util.Comparator;

public class AJHeap<E> implements AJQueue<E> {

	private java.util.ArrayList<E> list = new java.util.ArrayList<>();
	private java.util.Comparator<? super E> c;
	
	public AJHeap() {
		this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
	}
	
	public AJHeap(E[] objects) {
		this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
		for (int i=0; i<objects.length; i++) {
			addSong(objects[i]);
		}
	}
	
	public AJHeap(Comparator<? super E> c) {
		this.c = c;
	}
	
	@Override
	public void addSong(E e) {
		list.add(e);
		int currentIndex = list.size()-1;
		
		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1)/2;
			//Swap if the current song comparison is less than its parent.
			if (c.compare(list.get(currentIndex),list.get(parentIndex)) > 0) {
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
			}
			else
				break; //Tree is a heap now.
			
			currentIndex = parentIndex;
		}
		
	}

	@Override
	public void deleteAll() {
		list.clear();
	}

	@Override
	public boolean isEmpty() {
		return list.size() == 0;
	}

	@Override
	public E peekSong() {
		if (list.size() == 0) return null;
		
		return list.get(0);
	}

	@Override
	public void pushSong(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E removeSong() {
		if (list.size() == 0) return null;

	    E removedObject = list.get(0);
	    list.set(0, list.get(list.size() - 1));
	    list.remove(list.size() - 1);

	    int currentIndex = 0;
	    while (currentIndex < list.size()) {
	      int leftChildIndex = 2 * currentIndex + 1;
	      int rightChildIndex = 2 * currentIndex + 2;

	      // Find the minimum between two children
	      if (leftChildIndex >= list.size()) break; // The tree is a heap
	      int maxIndex = leftChildIndex;
	      if (rightChildIndex < list.size()) {
	        if (c.compare(list.get(maxIndex),
	            list.get(rightChildIndex)) < 0) {
	          maxIndex = rightChildIndex;
	        }
	      }

	      // Swap if the current node is greater than the maximum
	      if (c.compare(list.get(currentIndex), 
	      		list.get(maxIndex)) < 0) {
	        E temp = list.get(maxIndex);
	        list.set(maxIndex, list.get(currentIndex));
	        list.set(currentIndex, temp);
	        currentIndex = maxIndex;
	      }
	      else
	        break; // The tree is a heap
	    }
	    return removedObject;
	}
	@Override
	public int size() {
		return list.size();
	}
	
	public void printHeap() {
		  this.list.forEach(i -> System.out.print(i + " "));
	}
}
