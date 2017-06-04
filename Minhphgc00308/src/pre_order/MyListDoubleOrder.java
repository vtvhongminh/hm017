package pre_order;

import java.util.ArrayList;
import java.util.List;

import DAO.ModulOrder;

import Model.*;

public class MyListDoubleOrder<E> {
	protected MyListNodeDoubleOrder<E> head;
	protected MyListNodeDoubleOrder<E> tail;
	private int counter = 0;

	public MyListDoubleOrder() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void add(E x) {
		MyListNodeDoubleOrder<E> q = new MyListNodeDoubleOrder<E>(x);

		if (head == null) {
			head = tail = q;
		} else {
			q.prev = tail;
			tail.next = q;
			tail = q;
		}

		counter++;
	}

	public MyListNodeDoubleOrder<E> first() {
		return head;
	}

	public void dump() {
		List<E> sh = new ArrayList<E>();
		List<String> ssh = new ArrayList<>();
		for (MyListNodeDoubleOrder<E> h = head; h != null; h = h.next) {
			// x System.out.println( "h. info :" + h.infor);
			ssh.add((String) h.infor);
		}
		ModulOrder m = new ModulOrder();

	
	}

	public void removeByName(String s) {
		for (MyListNodeDoubleOrder<E> h = head; h != null; h = h.next) {
			if (s.equals(h.infor)) {
				remove(h);
				break;
			}
		}
	}

	public void removeByNameMany(String s) {
		for (MyListNodeDoubleOrder<E> h = head; h != null; h = h.next) {
			if (s.equals(h.infor)) {
				try {
					remove(h.next);
				}

				catch (Exception e) {
					// TODO: handle exception
					remove(head);

				}
			}
		}
	}

	public void remove(int n) {
		int k = 0;
		for (MyListNodeDoubleOrder<E> h = head; h != null; h = h.next) {
			if (k == n) {
				remove(h);
				break;
			}
			k++;
		}

	}

	public void remove(MyListNodeDoubleOrder<E> q) {
		MyListNodeDoubleOrder<E> hq = q.prev;
		MyListNodeDoubleOrder<E> tq = q.next;

		if (tq != null)
			tq.prev = hq;
		if (hq != null)
			hq.next = tq;

		if (q == head)
			head = tq;
		if (q == tail)
			tail = hq;

		counter--;
	}

	public int size() {
		return counter;
	}

}
