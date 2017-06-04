package pre_pd;

import Model.Res;

public class SearchNode {

	public SearchNode() {}
	
	public SearchNode(String d) { data = d;}
	
	@Override
	public String toString() {
		return data;
//		return "id="+Res.code(this)
//		+", data=" + data
//		+ ", parent=" + Res.code(parent)
//		+ ", left=" + Res.code(left)
//		+ ", right=" + Res.code(right);
	}

	public String data;
	public SearchNode left;
	public SearchNode right;
	public SearchNode parent;
	
	public int getLevel() 
	{
		int l = 0;
		for(SearchNode t=this; t!= null; t = t.parent) l++; 
		return l;
	}

}
