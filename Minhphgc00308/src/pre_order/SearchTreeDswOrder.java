package pre_order;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;


import DAO.ModulOrder;

import pre_pd.SearchNode;
import pre_pd.SearchTree;
import Managerment_pd.*;

public class SearchTreeDswOrder extends SearchTreeOrder 
{
	public SearchTreeDswOrder() 
	{
		
	}
	public SearchTreeDswOrder(SearchNode n) 
	{
		super(n);
	}

	public void flatten() 
	{
		SearchNode x1 = root;
		
		while(x1 != null) 
		{
			x1 = rotateLeft(x1);
			x1 = x1.right;
		}

		return;
	}

	private SearchNode rotateLeft(SearchNode x1) 
	{
		while(x1.left != null) 
		{
			SearchNode x2 = x1.left;
			SearchNode r2 = x2.right;
			
			x1.left = r2;
			if(r2 != null) r2.parent = x1;
			
			x2.right = x1;
			
			if(x1.parent == null) root = x2;
			else if(x1.parent.left==x1) x1.parent.left = x2;
			else if(x1.parent.right==x1) x1.parent.right = x2;
			
			x2.parent = x1.parent; 
			x1.parent = x2;
			
			x1 = x2;
		}
		
		return x1;
	}

	public Set<String> collect(Set<String> s) 
	{
		Stack<SearchNode> todo = new Stack<SearchNode>();
		if(root != null) todo.push(root);
		
		while(!todo.isEmpty())
		{
			SearchNode cur = todo.pop();
			s.add(cur.data);
			
			if(cur.right != null) todo.push(cur.right);
			if(cur.left != null) todo.push(cur.left);
		}
		ModulOrder ps = new ModulOrder();
		
		//ArrayList<String> arrays = new ArrayList<String>();
		new ArrayList<String>(s);
		List<Object> list = new ArrayList<Object>(10000000);
		list.addAll(s);
		ps.getsort(list);
		return s;
		
	}
	public Set<String> collects(Set<String> s) 
	{
		Stack<SearchNode> todo = new Stack<SearchNode>();
		if(root != null) todo.push(root);
		
		while(!todo.isEmpty())
		{
			SearchNode cur = todo.pop();
			s.add(cur.data);
			
			if(cur.right != null) todo.push(cur.right);
			if(cur.left != null) todo.push(cur.left);
		}
		ModulOrder ps = new ModulOrder();
		
		//ArrayList<String> arrays = new ArrayList<String>();
		new ArrayList<String>(s);
		List<Object> list = new ArrayList<Object>(10000000);
		list.addAll(s);
		ps.getsortp(list);
		return s;
		
	}

//	public void fold(String c) {
//		while(true) {
//			SearchNode x1 = root;
//			while(x1 != null) {
//				x1 = fold(x1);
//				if(root.data == c) break;
//			}
//			if(root.data == c) break;
//		}
//		return;
//	}

//	private SearchNode fold(SearchNode x1) 
//	{
//		if(x1==null || x1.right == null) return null;
//		//System.out.println("folding " + x1);
//		
//		SearchNode x2 = x1.right;
//		SearchNode l2 = x2.left;
//		
//		x1.right = l2;
//		if(l2 != null) l2.parent = x1;
//		
//		x2.left = x1;
//		
//		if(x1.parent == null) root = x2;
//		else if(x1.parent.left==x1) x1.parent.left = x2;
//		else if(x1.parent.right==x1) x1.parent.right = x2;
//		
//		x2.parent = x1.parent; 
//		x1.parent = x2;
//		
//		x1 = x2.right;
//		if(x1 != null) x1 = x1.right;
//		
//		//this.dump(true);
//		
//		return x2.right;
//	}

	public void addMany(String... args)
	{
		for(String ak: args) add(ak);
	}


}
