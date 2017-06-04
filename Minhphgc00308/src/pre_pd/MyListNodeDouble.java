package pre_pd;

public class MyListNodeDouble<E> 
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
	public MyListNodeDouble<E> next;
	public MyListNodeDouble<E> prev;

	public MyListNodeDouble(E x) 
	{
		infor = x;
	}
}
