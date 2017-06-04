package pre_customer;

import java.util.ArrayList;
import java.util.List;

import DAO.ModulCus;

import Model.*;

public class MyListDoubleCus<E> {
	protected MyListNodeDoubleCus<E> head;
	protected MyListNodeDoubleCus<E> tail;
	private int counter = 0;

	public MyListDoubleCus() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void add(E x) {
		MyListNodeDoubleCus<E> q = new MyListNodeDoubleCus<E>(x);

		if (head == null) {
			head = tail = q;
		} else {
			q.prev = tail;
			tail.next = q;
			tail = q;
		}

		counter++;
	}

	public MyListNodeDoubleCus<E> first() {
		return head;
	}

	public void dump() {
		List<E> sh = new ArrayList<E>();
		List<String> ssh = new ArrayList<>();
		for (MyListNodeDoubleCus<E> h = head; h != null; h = h.next) {
			// x System.out.println( "h. info :" + h.infor);
			ssh.add((String) h.infor);
		}
		ModulCus m = new ModulCus();

		m.getAdbxc(ssh);
	}

	public void removeByName(String s) {
		for (MyListNodeDoubleCus<E> h = head; h != null; h = h.next) {
			if (s.equals(h.infor)) {
				remove(h);
				break;
			}
		}
	}

	public void removeByNameMany(String s) {
		for (MyListNodeDoubleCus<E> h = head; h != null; h = h.next) {
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
		for (MyListNodeDoubleCus<E> h = head; h != null; h = h.next) {
			if (k == n) {
				remove(h);
				break;
			}
			k++;
		}

	}

	public void remove(MyListNodeDoubleCus<E> q) {
		MyListNodeDoubleCus<E> hq = q.prev;
		MyListNodeDoubleCus<E> tq = q.next;

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
