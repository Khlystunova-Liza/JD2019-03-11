package by.it.eslaikouskaya.jd01_11;

import java.util.*;

public class SetC<T> implements List<T> {

	private T[]elements = (T[]) new Object[]{};
	private int size = 0;

	@Override
	public boolean add(T t) {
		if (size==elements.length)
			elements= Arrays.copyOf(elements, (size*3)/2+1);
		elements[size++]=t;
		return true;
	}


	@Override
	public void add(int index, T element) {
		if (size==elements.length)
			elements= Arrays.copyOf(elements, (size*3)/2+1);
		System.arraycopy(elements, index, elements, index+1, size-index);
		elements[index]=element;
		size++;
	}

	@Override
	public T remove(int index) {
		T del = elements[index];
		System.arraycopy(elements,index+1, elements,index,size-1-index);
		size--;
		return del;
	}

	@Override
	public boolean remove(Object o) {
		int index=indexOf(o);
		if (index>-1) remove(index);
		return (index>-1);
	}


	@Override
	public T get(int index) {
		return elements[index];
	}



	@Override
	public T set(int index, T element) {
		T buffer = elements[index];
		elements[index]=element;
		return buffer;
	}



	@Override
	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++)
				if (elements[i] == null)
					return i;
		} else {
			for (int i = 0; i < size; i++)
				if (o.equals(elements[i]))
					return i;
		}
		return -1;
	}


	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("[");
		String delimiter="";
		for (int i = 0; i < size; i++) {
			sb.append(delimiter).append(elements[i]);
			delimiter=", ";
		}
		sb.append("]");
		return  sb.toString();
	}


	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < size; i++)
				if (o.equals(elements[i]))
		return true;
				return false;
	}



	//todo
	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	//todo
	@Override
	public boolean removeAll(Collection<?> c){
return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		T[] a = (T[]) c.toArray();
		int capacity = size + a.length;
		if (capacity > elements.length)
			elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
		System.arraycopy(a,0, elements,size, a.length);
		size += a.length;
		return a.length != 0;
	}






	//stub
	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		return false;
	}

	@Override
	public <T1> T1[] toArray(T1[] a) {
		return null;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

	}
	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return null;
	}
}
