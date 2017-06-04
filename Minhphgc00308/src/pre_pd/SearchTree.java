package pre_pd;

import java.io.File;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import DAO.ModulProduct;
import Model.Customer;
import Model.Product;;

public class SearchTree {
	private List<Product> items;
	public SearchNode root = null;

	public SearchTree() {

	}

	public SearchTree(SearchNode n) {
		root = n;
	}
//
	public void dump() {
		dump(false);
	}

	public void dump(boolean dash) {

		System.out.println("======= tree ");
		if (root == null)
			System.out.println("Empty tree");
		Stack<SearchNode> todo = new Stack<SearchNode>();
		if (root != null)
			todo.push(root);
		List<String> sc = new ArrayList<>();
		ModulProduct p = new ModulProduct();
		while (!todo.isEmpty()) {
			SearchNode cur = todo.pop();

			String a = cur.toString();

			sc.add(a);

			if (dash)
				for (int k = 0; k < cur.getLevel(); k++)
					System.out.print("-- ");
			System.out.println(cur);

			if (cur.right != null)
				todo.push(cur.right);
			if (cur.left != null)
				todo.push(cur.left);

		}
		//String b = sc.toString();
		
		return;
	}

//////////
	//
	public void dumpde() {
		dumpde(false);
	}

	public void dumpde(boolean dash) {

		System.out.println("======= tree ");
		if (root == null)
			System.out.println("Empty tree");
		Stack<SearchNode> todo = new Stack<SearchNode>();
		if (root != null)
			todo.push(root);
		List<String> sc = new ArrayList<>();
		ModulProduct p = new ModulProduct();
		while (!todo.isEmpty()) {
			SearchNode cur = todo.pop();

			String a = cur.toString();

			sc.add(a);

			if (dash)
				for (int k = 0; k < cur.getLevel(); k++)
					System.out.print("-- ");
			System.out.println(cur);

			if (cur.right != null)
				todo.push(cur.right);
			if (cur.left != null)
				todo.push(cur.left);

		}
		//String b = sc.toString();
		 p.deleteBy_pcode(sc);
		return;
	}

//////////

	public void add(String x) {
		SearchNode n = new SearchNode();
		n.data = x;

		if (root == null)
			root = n;
		else
			add(n, root);
	}

	private void add(SearchNode n, SearchNode p) {
		if (n.data.compareTo(p.data) < 0) {
			if (p.left == null) {
				p.left = n;
				n.parent = p;
			} else
				add(n, p.left);
		}
		if (n.data.compareTo(p.data) > 0) {
			if (p.right == null) {
				p.right = n;
				n.parent = p;
			} else
				add(n, p.right);
		}
	}

	public boolean search(String x) {
		if (root == null)
			return false;
		return search(x, root) != null;
	}

	private SearchNode search(String x, SearchNode n) {
		if (x.equals(n.data))
			return n;
		if ((x.compareTo(n.data) < 0) && n.left != null)
			return search(x, n.left);
		else if ((x.compareTo(n.data) > 0) && n.right != null)
			return search(x, n.right);
		else
			return null;
	}

	public void remove(String x) {
		if (root == null)
			return;
		SearchNode p = search(x, root);
		if (p != null)
			remove(p, p.parent);

	}

	private void remove(SearchNode n, SearchNode p) {
		// if n has only one child c, and p.left==n,then p.left = c
		// if n has only one child c, and p.right==n,then p.right = c
		if (n.left == null || n.right == null) {
			SearchNode c = (n.left == null ? n.right : n.left);

			if (p == null) {
				root = c;
			}

			else {
				if (p.left == n)
					p.left = c;
				else if (p.right == n)
					p.right = c;
			}

			if (c != null)
				c.parent = p;
		}

		// if n has both children
		else {
			SearchNode t = n.left;
			while (t.left != null)
				t = t.left;
			t.parent.left = t.right;
			n.data = t.data;
		}
	}

}
