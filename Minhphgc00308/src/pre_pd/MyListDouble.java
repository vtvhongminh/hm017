package pre_pd;

import java.util.ArrayList;
import java.util.List;

import DAO.ModulProduct;
import Model.*;

public class MyListDouble<E> {
	protected MyListNodeDouble<E> head;
	protected MyListNodeDouble<E> tail;
	private int counter = 0;

	public MyListDouble() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void add(E x) {
		MyListNodeDouble<E> q = new MyListNodeDouble<E>(x);

		if (head == null) {
			head = tail = q;
		} else {
			q.prev = tail;
			tail.next = q;
			tail = q;
		}

		counter++;
	}

	public MyListNodeDouble<E> first() {
		return head;
	}

	public void dump() {
		List<E> sh = new ArrayList<E>();
		List<String> ssh = new ArrayList<>();
		for (MyListNodeDouble<E> h = head; h != null; h = h.next) {
			// x System.out.println( "h. info :" + h.infor);
			ssh.add((String) h.infor);
		}
		ModulProduct m = new ModulProduct();

		m.getAdbxc(ssh);
	}

	public void removeByName(String s) {
		for (MyListNodeDouble<E> h = head; h != null; h = h.next) {
			if (s.equals(h.infor)) {
				remove(h);
				break;
			}
		}
	}

	public void removeByNameMany(String s) {
		for (MyListNodeDouble<E> h = head; h != null; h = h.next) {
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
		for (MyListNodeDouble<E> h = head; h != null; h = h.next) {
			if (k == n) {
				remove(h);
				break;
			}
			k++;
		}

	}

	public void remove(MyListNodeDouble<E> q) {
		MyListNodeDouble<E> hq = q.prev;
		MyListNodeDouble<E> tq = q.next;

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
