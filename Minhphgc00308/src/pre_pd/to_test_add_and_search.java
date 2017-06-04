package pre_pd;

public class to_test_add_and_search {

	public static void main(String[] args) throws Exception
	{
		SearchTree t = new SearchTree();
		t.add("a");
		t.add("b");
		
		
		t.dump(true);
		
		boolean r = t.search("a");
		System.out.println("Tim 17: " + r);

		r = t.search("c");
		System.out.println("Tim 18: " + r);
	}

}
