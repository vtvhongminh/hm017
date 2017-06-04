package pre_order;

public class MyListNodeDoubleOrder<E> 
{
	@Override
	public String toString() {
		return (String) infor;
	}

	private int code(Object src) 
	{
		return src==null ? 0 : src.hashCode();
	}

	public E infor;
	public MyListNodeDoubleOrder<E> next;
	public MyListNodeDoubleOrder<E> prev;

	public MyListNodeDoubleOrder(E x) 
	{
		infor = x;
	}
}
